package com.kata.clientprofilefacade1.util;
import com.kata.clientprofilefacade1.models.ProfileToken;
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
import static com.kata.clientprofilefacade1.util.JwtTokenGenerator.ACCESS_SECRET_KEY;
import static com.kata.clientprofilefacade1.util.JwtTokenGenerator.REFRESH_SECRET_KEY;

/**
 * сервис валидации и проверки токенов
 */
@Component
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SecureUtils {
    private final JwtTokenGenerator jwtTokenGenerator;
    public String refreshTokens(String token) {
        return jwtTokenGenerator.generateBearerOrJwtBearerToken(token);
    }
    public boolean validateRefreshToken(String refreshToken) {
        return validateToken(refreshToken, REFRESH_SECRET_KEY);
    }
    private boolean validateToken(String token, String key) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtTokenGenerator.secretKeyFabric(key))
                    .build()
                    .parseClaimsJws(token);
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
        return false;
    }
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
    public boolean validateRefreshTokenByJwtBearerOrBearerToken(ProfileToken profileTokensByBearerOrJwtBearerToken) {
        return validateRefreshToken(profileTokensByBearerOrJwtBearerToken.getRefreshToken());
    }
}
