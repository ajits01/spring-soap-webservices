//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.10 at 05:28:09 PM IST 
//


package io.github.ajits01.soapwebservices.jaxb;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.github.ajits01.soapwebservices.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.github.ajits01.soapwebservices.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBookDetailsRequest }
     * 
     */
    public GetBookDetailsRequest createGetBookDetailsRequest() {
        return new GetBookDetailsRequest();
    }

    /**
     * Create an instance of {@link GetBookDetailsResponse }
     * 
     */
    public GetBookDetailsResponse createGetBookDetailsResponse() {
        return new GetBookDetailsResponse();
    }

    /**
     * Create an instance of {@link BookDetails }
     * 
     */
    public BookDetails createBookDetails() {
        return new BookDetails();
    }

    /**
     * Create an instance of {@link DeleteBookDetailsRequest }
     * 
     */
    public DeleteBookDetailsRequest createDeleteBookDetailsRequest() {
        return new DeleteBookDetailsRequest();
    }

    /**
     * Create an instance of {@link DeleteBookDetailsResponse }
     * 
     */
    public DeleteBookDetailsResponse createDeleteBookDetailsResponse() {
        return new DeleteBookDetailsResponse();
    }

    /**
     * Create an instance of {@link GetAllBookDetailsRequest }
     * 
     */
    public GetAllBookDetailsRequest createGetAllBookDetailsRequest() {
        return new GetAllBookDetailsRequest();
    }

    /**
     * Create an instance of {@link GetAllBookDetailsResponse }
     * 
     */
    public GetAllBookDetailsResponse createGetAllBookDetailsResponse() {
        return new GetAllBookDetailsResponse();
    }

}
