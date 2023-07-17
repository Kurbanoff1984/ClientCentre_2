package com.kata.clientprofilefacade1.util;

import com.kata.clientprofilefacade1.models.ProfileToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Date;
import java.util.List;

/**
 * сервис генерации новых токенов
 */
@Component
public class JwtTokenGenerator {
    @Value("${access.secret.key}")
    protected static String ACCESS_SECRET_KEY;
    @Value("${refresh.secret.key}")
    protected static String REFRESH_SECRET_KEY;
    @Value("${secret.roles}")
    protected static List<String> ROLES;
    @Value("${access.time}")
    protected static int ACCESS_TIME;
    @Value("${refresh.time}")
    protected static int REFRESH_TIME;
    @Value("${bearer.length}")
    protected static int BEARER_LENGTH;
    protected SecretKey secretKeyFabric(String key) {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    public ProfileToken generateAllTokens() {
        Date now = new Date();
        Date accessDate = new Date(now.getTime() + (long) ACCESS_TIME *60*1000);// 5 min expiration
        Date refreshDate = new Date(now.getTime() + (long) REFRESH_TIME *60*1000); // 1 day expiration
        String JwtBearerToken = "JwtBearer "+ Jwts.builder()
                .claim("role", ROLES)
                .setIssuedAt(now)
                .setExpiration(accessDate)
                .signWith(secretKeyFabric(ACCESS_SECRET_KEY))
                .compact();
        String JwtRefreshToken = Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(refreshDate)
                .signWith(secretKeyFabric(REFRESH_SECRET_KEY))
                .compact();
        return ProfileToken.builder()
                .jwtBearerToken(JwtBearerToken)
                .refreshToken(JwtRefreshToken)
                .bearerToken("Bearer "+ RandomStringUtils.randomAlphanumeric(BEARER_LENGTH))
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

