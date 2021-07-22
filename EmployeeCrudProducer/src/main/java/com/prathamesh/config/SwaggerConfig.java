package com.prathamesh.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	private ApiInfo apiInfo()
	{
		return new ApiInfo("My Employee Crud App", "Hello", "5.2 GA", "https://prathamesh.in", new Contact("Pathamesh", "https://prathamesh.in", "pra@aa.com"), "BB Licence", "https://prathamesh.in",Collections.emptyList());
	}
	
	@Bean
	public Docket createDocket() 
	{
	  return new Docket(DocumentationType.SWAGGER_2)
	  .select()
	  .apis(RequestHandlerSelectors.basePackage("com.prathamesh.rest"))
	  .paths(PathSelectors.regex("/rest.*"))
	  .build()
	  .apiInfo(apiInfo());
	}

}
