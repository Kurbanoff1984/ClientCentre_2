package com.kata.clientprofilefacade;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@OpenAPIDefinition(
        info = @Info(
                title = "Facade microservice",
                version = "1.0.0",
                description = "Microservice which is a bridge between front and backs",
                termsOfService = "google.com",
                contact = @Contact(
                        name = "",
                        email = ""
                ),
                license = @License (
                        name = "license",
                        url = ""
                ))
)
public class ClientProfileFacadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientProfileFacadeApplication.class, args);

    }

}
