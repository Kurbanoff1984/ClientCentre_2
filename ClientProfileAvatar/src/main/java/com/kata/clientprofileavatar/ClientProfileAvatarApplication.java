package com.kata.clientprofileavatar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
        info = @Info(
                title = "${progect.mcs.name}",
                version = "${vershon.mcs.prod}",
                description = "Author ${avtor.openapi.prod}",
                termsOfService = "${progect.mcs.termsOfService}",
                contact = @Contact(
                        name = "${avtor.openapi.prod}",
                        email = "${avtor.email.openapi.prod}"
                ),
                license = @License(
                        name = "github",
                        url = "${progect.openapi.prod-url}"
                )
        )
)

public class ClientProfileAvatarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientProfileAvatarApplication.class, args);
    }
}
