package com.commscope.bu;

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
public class BuisinessAPIApplication extends SpringBootServletInitializer {
	
	   @Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(BuisinessAPIApplication.class);
	   }

	public static void main(String[] args) {
		SpringApplication.run(BuisinessAPIApplication.class, args);
	}

}
