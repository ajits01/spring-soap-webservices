package io.github.ajits01.soapwebservices.soap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import io.github.ajits01.soapwebservices.soap.Status;
import io.github.ajits01.soapwebservices.soap.bean.Book;

@Service
public class BookDetailsServiceImpl implements BookDetailsService {

  @Override
  public Optional<Book> findByIsbn(String isbn) {
    
    return books.stream().filter((book)-> book.filterByIsbn(isbn)).findFirst();
  }

  @Override
  public Optional<List<Book>> findAll() {
    
    return Optional.of(books);
  }

  @Override
  public Status deleteByIsbn(String isbn) {
    
    boolean status = books.removeIf((book)-> book.filterByIsbn(isbn));
    return status ? Status.SUCCESS : Status.FAILURE;
  }
  
  @SuppressWarnings("serial")
  public static List<Book> books =
      new ArrayList<Book>() {
        {
          add(
              new Book(
                  "9780134685991",
                  "Effective Java",
                  "Joshua Bloch",
                  "The Definitive Guide to Java Platform Best Practices"));
          add(
              new Book(
                  "9781260440249",
                  "Java: The Complete Reference, Eleventh Edition, 11th Edition",
                  "Herbert Schildt",
                  "The Definitive Java Programming Guide"));
          add(
              new Book(
                  "0596007124",
                  "Head First Design Patterns",
                  "Kathy Sierra, Bert Bates, Elisabeth Robson, Eric Freeman",
                  "Shows you the tried-and-true, road-tested patterns used by developers to create functional, elegant, reusable, and flexible software"));
        }
      };
      
}
