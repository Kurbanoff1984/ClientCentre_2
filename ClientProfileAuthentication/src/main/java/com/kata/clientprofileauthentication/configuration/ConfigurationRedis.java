package com.kata.clientprofileauthentication.configuration;

import com.kata.clientprofileauthentication.models.tokens.ProfileToken;
import com.kata.clientprofileauthentication.repository.tokenRepository.ProfileTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
/**
 * класс конфигурации подключения к redis
 */
@Configuration
@EnableRedisRepositories
@Slf4j
public class ConfigurationRedis {
    @Value("${spring.data.redis.url}")
    private String HOST;
    @Value(value = "${spring.data.redis.port}")
    private int PORT;

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
            redisStandaloneConfiguration.setHostName(HOST);
            redisStandaloneConfiguration.setPort(PORT);
            return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
    /**
     * тестовый метод для создание 2ух моделей токенов в бд
     * @param repo - создание дефолтной бд с двумя токенами для тестов
     * @return - //
     */
    @Bean
    public CommandLineRunner commandLineRunner(ProfileTokenRepository repo) {
        return args -> {
            ProfileToken token1 = new ProfileToken(
                    "Bearer 0ftU7yZ4b86OoUs59vb0irO4tmYpNFtoc8CHdkWNJL0tCx2A7jOdoGsSS4KVMlIp",
                    "JwtBearer eyJhbGciOiJIUzM4NCJ9.eyJyb2xlIjoiQ0xJRU5UIiwiaWF0IjoxNjg5MDg2Mjg4LCJleHAiOjE2ODkwODYzNDh9.22p7nLxdlcbZ7QHARMItVC8qGVf8awxZ4BSd7wE1n5TNoDd8GJdPDJ6lBdV5mjgP",
                    "eyJhbGciOiJIUzM4NCJ9.eyJpYXQiOjE2ODkwODYyODgsImV4cCI6MTY4OTA4NjU4OH0.PZVDJcwNUvWoXsN711X8Ud7KBgYQx6k_xhvQD_KLtYwEI29V5blyMP-0Vv9c8Z1p");
            ProfileToken token2 = new ProfileToken(
                    "Bearer du0abncoLQg8cFDwvp0bzKuQGFuIDIiI2UuyXDL7KKp3HpKYO2UktSgnLsmCwMEf",
                    "JwtBearer eyJhbGciOiJIUzM4NCJ9.eyJyb2xlIjoiQ0xJRU5UIiwiaWF0IjoxNjg5MDg2Mjg4LCJleHAiOjE2ODkwODYzNDh9.22p7nLxdlcbZ7QHARMItVC8qGVf8awxZ4BSd7wE1n5TNoDd8GJdPDJ6lBdV5mjgP",
                    "eyJhbGciOiJIUzM4NCJ9.eyJpYXQiOjE2ODkwODYyODgsImV4cCI6MTY4OTA4NjU4OH0.PZVDJcwNUvWoXsN711X8Ud7KBgYQx6k_xhvQD_KLtYwEI29V5blyMP-0Vv9c8Z1p");
            ProfileToken token3 = new ProfileToken(
                    "Bearer N2PmDuURGR2r766p0Q3epRUOBUqNZwZYLzNQ7XK5sNV1GW0URsfDBOdleNLXJZBG",
                    "JwtBearer eyJhbGciOiJIUzM4NCJ9.eyJyb2xlIjoiQ1JFRElUIiwiaWF0IjoxNjg3NTE1Nzk2LCJleHAiOjE2ODc1MTYwOTZ9.-0hz7JRx9PekRtUcuUx0_h4JcHnpaQB9gE52tpHbJlRcQ2CiZy8-2drQDkOsNrCp",
                    "eyJhbGciOiJIUzM4NCJ9.eyJpYXQiOjE2ODc1MTU3OTYsImV4cCI6MTY4NzYwMjE5Nn0.9GYkYVhFBcQFWiPtdC6lQQfclVqGzZwae9Fdm520Or5jn7-59JTQ1Pak_-MeeCyq");
            ProfileToken token4 = new ProfileToken(
                    "Bearer VjNe4crMNiNnuYpPMGVjNfPT3ixtwgpPwhH9XkMfxDejaUVc5mOmjaIzxH30blIf",
                    "JwtBearer eyJhbGciOiJIUzM4NCJ9.eyJyb2xlIjoiQ1JFRElUIiwiaWF0IjoxNjg3NTE1Nzk0LCJleHAiOjE2ODc1MTYwOTR9.UTM6pblNkysPVYKgFpxGR35jMGUTe7DD092AIZ_NtPwhh2S2HhL0nA_04lYvRGGJ",
                    "eyJhbGciOiJIUzM4NCJ9.eyJpYXQiOjE2ODc1MTU3OTQsImV4cCI6MTY4NzYwMjE5NH0.w0FSRrZdesMJCVeTmYildOdM42z_gj7thXO2xy5cUK2u7uXTec9vHCCEiwUAcaIG");
            repo.deleteAll();
            repo.save(token1);
            repo.save(token2);
            repo.save(token3);
            repo.save(token4);
            log.info("Создание тестовых токенов");
        };
    }
}
