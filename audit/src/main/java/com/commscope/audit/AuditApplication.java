package com.commscope.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * This is the start up class for the application
 * @author RT1050
 *
 */

@SpringBootApplication
public class AuditApplication extends SpringBootServletInitializer {
	
	   @Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(AuditApplication.class);
	   }

	public static void main(String[] args) {
		SpringApplication.run(AuditApplication.class, args);
	}

}
