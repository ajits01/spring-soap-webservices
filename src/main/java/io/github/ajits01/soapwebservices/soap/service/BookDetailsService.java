package io.github.ajits01.soapwebservices.soap.service;

import java.util.List;
import java.util.Optional;
import io.github.ajits01.soapwebservices.soap.Status;
import io.github.ajits01.soapwebservices.soap.bean.Book;

public interface BookDetailsService {

  Optional<Book> findByIsbn(String isbn);

  Optional<List<Book>> findAll();

  Status deleteByIsbn(String isbn);
}
