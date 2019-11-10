package io.github.ajits01.soapwebservices.soap.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
  
  private String isbn;
  private String name;
  private String author;
  private String description;
  
  public boolean filterByIsbn(String isbn) {
    return this.getIsbn().equalsIgnoreCase(isbn);
  }
  
}
