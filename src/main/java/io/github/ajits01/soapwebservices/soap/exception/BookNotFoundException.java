package io.github.ajits01.soapwebservices.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(
    faultCode = FaultCode.CUSTOM,
    customFaultCode = "{"+BookNotFoundException.NAMESPACE_URI+"}BOOK_NOT_FOUND")
public class BookNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -689432152695528968L;
  public static final String NAMESPACE_URI = "http://io.github.ajits01/soapwebservices/books";

  public BookNotFoundException(String message) {
    super(message);
  }
}
