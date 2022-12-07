package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Autowired
	private Environment env;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.springboot")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(env.getProperty("swagger.api.info.title"))
				.description(env.getProperty("swagger.api.info.description"))

				.contact(getContactInfo()).license(env.getProperty("swagger.api.info.license"))
				.licenseUrl(env.getProperty("swagger.api.info.licenseUrl"))
				.version(env.getProperty("swagger.api.version")).build();
	}

	private Contact getContactInfo() {
		return new Contact(env.getProperty("swagger.api.info.contact.name"),
				env.getProperty("swagger.api.info.contact.url"), env.getProperty("swagger.api.info.contact.email"));
	}

}
