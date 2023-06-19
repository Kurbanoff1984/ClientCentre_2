package com.kata.clientprofilerecognition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ClientProfileRecognitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientProfileRecognitionApplication.class, args);
    }

}
