package com.kata.clientprofileauthentication.configuration;

import com.kata.clientprofileauthentication.models.auth.InputFormAndAuthentication;
import com.kata.clientprofileauthentication.repository.secureRepository.SecureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * класс конфигурации для подключения к postgresql
 */
@Configuration
@Slf4j
@Profile("test")
public class ConfigurationPostgresql {

    /**
     * тестовый метод для создание 2ух пользаков в бд
     * @param repo - создание дефолтной бд с двумя пользаками для тестов
     * @return - //
     */
    @Bean
    public CommandLineRunner commandLineRunner2(SecureRepository repo) {
        return args -> {
            InputFormAndAuthentication inp1 = new InputFormAndAuthentication(12L,"Андрей","Андреев",
                    "Андреевич","Andy@mail.ru", "ООО \"Все ужасно!\"",
                    "По приколу", "Andrei_ovseuzhasno@client.centre",
                    "$2a$10$YLpavfhdEvGD8uazoxeIZ.rGfItuszdmr9Q3ny/appvxmEK9OdpJO",false);
            /**
             * пароль b7b0FYtgA7
             */
            InputFormAndAuthentication inp2 = new InputFormAndAuthentication(13L,"Олег","Тиньков",
                    "Олегович","Tinkoff@mail.ru", "ООО \"ТинькоффИнвстишн!\"",
                    "Я так чувствую", "Oleg_otinkofvssh@client.centre",
                    "$2a$10$VyfLahfGmhQq9tSrsUI4MuIV5LXGQXm1wMmAwe.1DJ.Z10g3v3HcK", false);
            /**
             * пароль sn3zLiIo5zhra
             */
            repo.deleteAll();
            repo.save(inp1);
            repo.save(inp2);
            log.info("Создание тестовых пользоватлей");
        };
    }
}
