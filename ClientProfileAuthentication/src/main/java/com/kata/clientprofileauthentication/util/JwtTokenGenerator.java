package com.kata.clientprofileauthentication.util;

import com.kata.clientprofileauthentication.models.tokens.ProfileToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Date;

import static com.kata.clientprofileauthentication.util.PropertiesInitialization.ACCESS_SECRET_KEY;
import static com.kata.clientprofileauthentication.util.PropertiesInitialization.ACCESS_TIME;
import static com.kata.clientprofileauthentication.util.PropertiesInitialization.BEARER_LENGTH;
import static com.kata.clientprofileauthentication.util.PropertiesInitialization.REFRESH_SECRET_KEY;
import static com.kata.clientprofileauthentication.util.PropertiesInitialization.REFRESH_TIME;
import static com.kata.clientprofileauthentication.util.PropertiesInitialization.ROLES;

/**
 * сервис генерации новых токенов
 */
@Component
@Slf4j
public class JwtTokenGenerator {
    protected SecretKey secretKeyFabric(String key) {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    public ProfileToken generateAllTokens() {
        Date now = new Date();
        Date accessDate = new Date(now.getTime() + (long) ACCESS_TIME *60*1000);// 5 min expiration
        Date refreshDate = new Date(now.getTime() + (long) REFRESH_TIME *60*1000); // 1 day expiration
        String JwtBearerToken = "JwtBearer "+ Jwts.builder()
                .claim("role", ROLES.get(1))
                .setIssuedAt(now)
                .setExpiration(accessDate)
                .signWith(secretKeyFabric(ACCESS_SECRET_KEY))
                .compact();
        String JwtRefreshToken = Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(refreshDate)
                .signWith(secretKeyFabric(REFRESH_SECRET_KEY))
                .compact();
        log.info("Модель токена "+ ROLES.get(1)+" сгенерирована");
        return ProfileToken.builder()
                .bearerToken("Bearer "+ RandomStringUtils.randomAlphanumeric(BEARER_LENGTH))
                .jwtBearerToken(JwtBearerToken)
                .refreshToken(JwtRefreshToken)
                .build();
    }
    public String generateBearerOrJwtBearerToken(String token) {
        Date now = new Date();
        Date accessDate = new Date(now.getTime() + (long) ACCESS_TIME *60*1000);
        if (token.startsWith("Bearer ")) {
            return "Bearer "+ RandomStringUtils.randomAlphanumeric(BEARER_LENGTH);
        } else {
            return "JwtBearer " + Jwts.builder()
                    .claim("role", ROLES)
                    .setIssuedAt(now)
                    .setExpiration(accessDate)
                    .signWith(secretKeyFabric(ACCESS_SECRET_KEY))
                    .compact();
        }
    }
}

