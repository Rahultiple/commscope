package com.commscope.bu.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * This is the swagger class which having swagger configuration
 * @author RT1050
 */
@Configuration    
@EnableSwagger2
public class BUConfig {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.commscope.bu"))
                .paths(regex("/.*"))
                .build();
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Email API")
				.description("Audditing API Framework")
				.termsOfServiceUrl("https://www.commscope.com")
				.contact("https://www.commscope.com/Contact-Us").license("Commscope License")
				.licenseUrl("https://www.commscope.com").version("1.0").build();
	}

}

