package com.store.firstmotors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful api with java 21 and Spring Boot 3.3.2")
                        .version("v1")
                        .description("Api de gerenciamento de estoque de loja de carros")
                        .termsOfService("https://www.instagram.com/")
                        .license(
                                new License().
                                        name("apache 2.0")
                                        .url("https://www.instagram.com/")));
    }

}
