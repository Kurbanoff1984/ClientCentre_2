package com.kata.clientprofilefacade;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@OpenAPIDefinition(
        info = @Info(
                title = "Masking microservice",
                version = "1.0.0",
                description = "Microservice for masking personal data",
                termsOfService = "google.com",
                contact = @Contact(
                        name = "Chong Nguyen",
                        email = "davidnguyen1432@gmail.com"
                ),
                license = @License (
                        name = "license",
                        url = "clientcentre.com"
                ))
)
public class ClientProfileFacadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientProfileFacadeApplication.class, args);

    }

}
