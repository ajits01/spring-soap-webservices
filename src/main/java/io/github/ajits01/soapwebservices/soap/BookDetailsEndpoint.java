package io.github.ajits01.soapwebservices.soap;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import io.github.ajits01.soapwebservices.jaxb.BookDetails;
import io.github.ajits01.soapwebservices.jaxb.DeleteBookDetailsRequest;
import io.github.ajits01.soapwebservices.jaxb.DeleteBookDetailsResponse;
import io.github.ajits01.soapwebservices.jaxb.GetAllBookDetailsRequest;
import io.github.ajits01.soapwebservices.jaxb.GetAllBookDetailsResponse;
import io.github.ajits01.soapwebservices.jaxb.GetBookDetailsRequest;
import io.github.ajits01.soapwebservices.jaxb.GetBookDetailsResponse;
import io.github.ajits01.soapwebservices.soap.bean.Book;
import io.github.ajits01.soapwebservices.soap.exception.BookNotFoundException;
import io.github.ajits01.soapwebservices.soap.service.BookDetailsService;

@Endpoint
public class BookDetailsEndpoint {

  private static final String NAMESPACE_URI = "http://io.github.ajits01/soapwebservices/books";
  @Autowired BookDetailsService service;

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBookDetailsRequest")
  @ResponsePayload
  public GetBookDetailsResponse processBookDetailsRequest(
      @RequestPayload GetBookDetailsRequest request) {

    Optional<Book> book = service.findByIsbn(request.getIsbn());
    if (book.isPresent()) {
      return mapBookDetailsResponse(book.get());
    } else {      
      throw new BookNotFoundException("Invalid ISBN : "+request.getIsbn());
    }
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllBookDetailsRequest")
  @ResponsePayload
  public GetAllBookDetailsResponse processAllBookDetailsRequest(
      @RequestPayload GetAllBookDetailsRequest request) {

    Optional<List<Book>> books = service.findAll();
    GetAllBookDetailsResponse response = new GetAllBookDetailsResponse();
    if (books.isPresent()) {
      return mapAllBookDetailsResponse(books.get());
    }
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteBookDetailsRequest")
  @ResponsePayload
  public DeleteBookDetailsResponse processDeleteBookDetailsRequest(
      @RequestPayload DeleteBookDetailsRequest request) {

    Status status = service.deleteByIsbn(request.getIsbn());
    DeleteBookDetailsResponse response = new DeleteBookDetailsResponse();
    response.setStatus(mapStatus(status));
    return response;
  }

  private GetBookDetailsResponse mapBookDetailsResponse(Book book) {

    GetBookDetailsResponse response = new GetBookDetailsResponse();
    BookDetails bd = mapBook(book);
    response.setBookDetails(bd);
    return response;
  }

  private GetAllBookDetailsResponse mapAllBookDetailsResponse(List<Book> book) {

    GetAllBookDetailsResponse response = new GetAllBookDetailsResponse();
    for (Book b : book) {
      BookDetails bd = mapBook(b);
      response.getBookDetails().add(bd);
    }
    return response;
  }

  private BookDetails mapBook(Book book) {
    BookDetails bd = new BookDetails();
    bd.setIsbn(book.getIsbn());
    bd.setName(book.getName());
    bd.setAuthor(book.getAuthor());
    bd.setDescription(book.getDescription());
    return bd;
  }
  
  private io.github.ajits01.soapwebservices.jaxb.Status mapStatus(Status status) {
    if (status == Status.FAILURE) {
      return io.github.ajits01.soapwebservices.jaxb.Status.FAILURE;
    }
    return io.github.ajits01.soapwebservices.jaxb.Status.SUCCESS;
  }
}
