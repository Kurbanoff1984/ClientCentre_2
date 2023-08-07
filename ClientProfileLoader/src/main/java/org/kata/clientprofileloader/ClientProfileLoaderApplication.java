package org.kata.clientprofileloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.kata.entity")
@EnableJpaRepositories(basePackages = "org.kata.repository")
public class ClientProfileLoaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientProfileLoaderApplication.class, args);
    }

}
