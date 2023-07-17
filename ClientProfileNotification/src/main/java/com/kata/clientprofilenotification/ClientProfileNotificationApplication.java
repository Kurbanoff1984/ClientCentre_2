package com.kata.clientprofilenotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientProfileNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientProfileNotificationApplication.class, args);
    }

}
