package com.kata.clientprofileupdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class ClientProfileUpdateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientProfileUpdateApplication.class, args);
    }

}
