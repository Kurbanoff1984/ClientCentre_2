package org.kata.clientprofileservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(@Value("${application-description}") String appDescription,
                                 @Value("${application-version}") String appVersion) {
        return new OpenAPI().info(new Info().title("ClientProfileService API")
                        .version(appVersion)
                        .description(appDescription)
                        .contact(new Contact().name("Alexander")
                                .email("apocaliptorus@gmail.com")))
                .addServersItem(new Server().url("http://localhost:8080/service-app/api")
                        .description("Context path application"));
    }
}





