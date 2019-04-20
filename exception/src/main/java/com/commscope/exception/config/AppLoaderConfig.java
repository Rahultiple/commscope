package com.commscope.exception.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.concurrent.Executor;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.commscope.exception.handleException.InputRequestValidator;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is class is used for Swagger documentation
 * @author RT1050
 *
 */

@Configuration
@EnableSwagger2
@ComponentScan(basePackages= {"com.commscope.exception"})
public class AppLoaderConfig {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.commscope.exception"))
                .paths(regex("/.*"))
                .build();
    }
 
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Exception")
				.description("Hello World message from SI and Azure App Service")
				.termsOfServiceUrl("https://www.commscope.com")
				.contact("https://www.commscope.com/Contact-Us").license("Commscope License")
				.licenseUrl("https://www.commscope.com").version("1.0").build();
	}
	/**
	 * Template bean creation object 
	 * @param restTemplateBuilder
	 * @return
	 */
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) 
    {
        return restTemplateBuilder
           .setConnectTimeout(15000)
           .setReadTimeout(15000)
           .build();
    }
	
	@Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor tpe = new ThreadPoolTaskExecutor();
        tpe.setMaxPoolSize(10);
        return tpe;
    }
	
	@Bean
	public InputRequestValidator beforeCreateWebsiteUserValidator() {
	    return new InputRequestValidator();
	}

}