package com.kata.clientprofileauthentication.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * класс инициализации статических переменных их application.properties
 */
@Component
@Slf4j
public class PropertiesInitialization {
    protected static String ACCESS_SECRET_KEY;
    protected static String REFRESH_SECRET_KEY;
    protected static List<String> ROLES;
    protected static int ACCESS_TIME;
    protected static int REFRESH_TIME;
    protected static int BEARER_LENGTH;
    @Autowired
    public PropertiesInitialization(@Value("${access.secret.key}") String ACCESS_SECRET_KEY,
                                    @Value("${refresh.secret.key}") String REFRESH_SECRET_KEY,
                                    @Value("${secret.token.claims.roles}") List<String> ROLES,
                                    @Value("${access.token.time}") int ACCESS_TIME,
                                    @Value("${refresh.token.time}") int REFRESH_TIME,
                                    @Value("${bearer.token.length}") int BEARER_LENGTH) {
        PropertiesInitialization.ACCESS_SECRET_KEY = ACCESS_SECRET_KEY;
        PropertiesInitialization.REFRESH_SECRET_KEY = REFRESH_SECRET_KEY;
        PropertiesInitialization.ROLES = ROLES;
        PropertiesInitialization.ACCESS_TIME = ACCESS_TIME;
        PropertiesInitialization.REFRESH_TIME = REFRESH_TIME;
        PropertiesInitialization.BEARER_LENGTH = BEARER_LENGTH;
        log.info("Инициализация переменных");
    }
}
