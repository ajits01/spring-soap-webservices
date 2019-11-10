package io.github.ajits01.soapwebservices.soap;

import java.util.Collections;
import java.util.List;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatherServlet(
      ApplicationContext ctx) {

    MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
    messageDispatcherServlet.setApplicationContext(ctx);
    messageDispatcherServlet.setTransformWsdlLocations(true);

    return new ServletRegistrationBean<MessageDispatcherServlet>(
        messageDispatcherServlet, "/wsapi/*");
  }

  @Bean(name = "books")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema booksSchema) {

    DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
    definition.setPortTypeName("BookPort");
    definition.setTargetNamespace("http://io.github.ajits01/soapwebservices/books");
    definition.setLocationUri("/wsapi");
    definition.setSchema(booksSchema);
    return definition;
  }

  @Bean
  XsdSchema booksSchema() {

    return new SimpleXsdSchema(new ClassPathResource("book-details.xsd"));
  }

  @Bean
  public XwsSecurityInterceptor securityInterceptor() {
    XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
    securityInterceptor.setCallbackHandler(callbackHandler());
    securityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
    return securityInterceptor;
  }

  @Bean
  public SimplePasswordValidationCallbackHandler callbackHandler() {
    SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();
    handler.setUsersMap(Collections.singletonMap("user", "password"));
    return handler;
  }

  @Override
  public void addInterceptors(List<EndpointInterceptor> interceptors) {
    super.addInterceptors(interceptors);
    interceptors.add(securityInterceptor());
  }
}
