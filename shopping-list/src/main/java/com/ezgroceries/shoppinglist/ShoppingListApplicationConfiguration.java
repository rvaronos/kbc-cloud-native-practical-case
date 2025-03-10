package com.ezgroceries.shoppinglist;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShoppingListApplicationConfiguration {

	// Custom tomcat configuration, we add a connector that allows http traffic next
	// to https
	@Bean
	public ServletWebServerFactory servletContainer(@Value("${server.http.port}") int httpPort) {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setPort(httpPort);

		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(connector);
		return tomcat;
	}

}
