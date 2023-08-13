package com.yadwy.yadwy.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI().info(new Info().title("yadwy.com")
			.description("Backend APIs for yadwy.com")
			.version("v1.0.0")
			.contact(new Contact().name("Hassan Refaat").url("https://www.linkedin.com/in/hassan-refaat-2a8823206/").email("hassan.refaat.dev@gmail.com"))
			.license(new License().name("License").url("/")))
			.externalDocs(new ExternalDocumentation().description("E-Commerce App Documentation")
			.url("http://localhost:8080/swagger-ui/index.html"));
	}
	
}
