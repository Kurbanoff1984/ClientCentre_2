package org.kata.clientprofileservice.config;

import org.kata.config.ExceptionRestController;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Configuration
public class UtilConfig {
    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public ExceptionRestController exceptionRestController() {
        return new ExceptionRestController();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
