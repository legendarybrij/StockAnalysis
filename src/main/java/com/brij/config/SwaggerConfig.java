package com.brij.config;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		//Docket decided what kind of APIs you would want to document
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}
	private Predicate<String> postPaths() {
		return or(regex("/.*") );
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger Documentation")
				.description(" Swagger Restful end point documentation")
				.termsOfServiceUrl("http://swagger.com")
				.contact("swagger@gmail.com").license("@Brij")
				.licenseUrl("patelbrijesh14@gmail.com").version("1.0").build();
	}
}



