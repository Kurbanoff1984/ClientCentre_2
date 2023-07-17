package com.kata.clientprofilefacade1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ClientProfileAuthenticationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientProfileAuthenticationApplication.class, args);
    }

}
