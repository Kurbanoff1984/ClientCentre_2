package com.kata.clientprofileauthentication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@OpenAPIDefinition(
        info = @Info(
                title = "${project.mcs.name}",
                description = "Author ${author.openapi.prod}", version = "${version.mcs.prod}",
                termsOfService = "${project.mcs.termsOfService}",
                contact = @Contact(
                        name = "${author.openapi.prod}",
                        email = "${author.email.openapi.prod}"
                ),
                license = @License(
                        name = "github",
                        url = "${project.openapi.prod-url}"
                )
        )
)
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ClientProfileAuthenticationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientProfileAuthenticationApplication.class, args);
    }

}
