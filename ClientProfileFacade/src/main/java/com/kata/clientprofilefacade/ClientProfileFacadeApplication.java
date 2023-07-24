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
                title = "${project.mcs.name}",
                version = "${version.mcs.prod}",
                description = "${author.description.prod}",
                termsOfService = "${project.mcs.termsOfService}",
                contact = @Contact(
                        name = "${author.openapi.prod}",
                        email = "${author.email.openapi.prod}"
                ),
                license = @License (
                        name = "license",
                        url = "${project.openapi.prod-url}"
                ))
)
public class ClientProfileFacadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientProfileFacadeApplication.class, args);

    }

}
