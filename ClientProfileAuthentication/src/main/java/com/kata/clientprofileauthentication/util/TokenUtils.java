package com.kata.clientprofileauthentication.util;
import com.kata.clientprofileauthentication.models.tokens.ProfileToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.kata.clientprofileauthentication.util.PropertiesInitialization.ACCESS_SECRET_KEY;
import static com.kata.clientprofileauthentication.util.PropertiesInitialization.REFRESH_SECRET_KEY;

/**
 * сервис валидации и проверки токенов
 */
@Component
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TokenUtils {
    private final JwtTokenGenerator jwtTokenGenerator;
    /**
     * метод для обновления jwtBearer или Bearer токенов
     * @param token - принимает на вход 1 jwtBearer или Bearer Токен
     * @return -возвращает обновленный токен
     */
    public String refreshTokens(String token) {
        return jwtTokenGenerator.generateBearerOrJwtBearerToken(token);
    }
    /**
     * метод проверки refresh токена
     * @param profileToken -  принимает на вход общий profiletoken
     * @return значение tru or false
     */
    public boolean validateRefreshTokenByJwtBearerOrBearerToken(ProfileToken profileToken) {
        return validateToken(profileToken.getRefreshToken(), REFRESH_SECRET_KEY);
    }
    private boolean validateToken(String token, String key) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtTokenGenerator.secretKeyFabric(key))
                    .build()
                    .parseClaimsJws(token);
            log.info("Токены валидны");
            return true;
        } catch (ExpiredJwtException expEx) {
            log.error("Token expired", expEx);
        } catch (UnsupportedJwtException unsEx) {
            log.error("Unsupported jwt", unsEx);
        } catch (MalformedJwtException mjEx) {
            log.error("Malformed jwt", mjEx);
        } catch (SignatureException sEx) {
            log.error("Invalid signature", sEx);
        } catch (Exception e) {
            log.error("invalid token", e);
        }
        log.warn("Токены невалидны");
        return false;
    }
    /**
     * методы который вытаскивает Claims (далле роли ROLES)
     * @param accessToken - JwtBearer токен
     * @return - вытаскивает claims по секретному ключу и JwtBearer токену
     */
    public Claims getAccessClaims(String accessToken) {
        return getClaims(accessToken, ACCESS_SECRET_KEY);
    }
    private Claims getClaims(String token, String key) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtTokenGenerator.secretKeyFabric(key))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
