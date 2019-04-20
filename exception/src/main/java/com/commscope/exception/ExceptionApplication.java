package com.commscope.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * This is startup of the application
 * @author RT1050
 *
 */
@SpringBootApplication
public class ExceptionApplication extends SpringBootServletInitializer {
		
	   @Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(ExceptionApplication.class);
	   }
	   public static void main(String[] args) {
	      SpringApplication.run(ExceptionApplication.class, args);
	      
	   }   
	   
	  
}

