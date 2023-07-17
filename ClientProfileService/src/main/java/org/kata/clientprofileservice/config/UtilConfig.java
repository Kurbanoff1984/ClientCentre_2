package org.kata.clientprofileservice.config;

import lombok.SneakyThrows;
import org.kata.config.ExceptionRestController;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

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
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(dateConverter());
        return modelMapper;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Converter<String, Date> dateConverter() {
        return new Converter<String, Date>() {
            @SneakyThrows
            @Override
            public Date convert(MappingContext<String, Date> context) {
                String dateString = context.getSource();
                SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
                inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date = inputFormat.parse(dateString);
                return date;

            }
        };
    }

}
