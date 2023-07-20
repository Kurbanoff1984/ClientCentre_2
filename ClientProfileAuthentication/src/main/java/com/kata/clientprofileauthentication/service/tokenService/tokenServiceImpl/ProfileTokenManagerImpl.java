package com.kata.clientprofileauthentication.service.tokenService.tokenServiceImpl;

import com.kata.clientprofileauthentication.models.tokens.BlackToken;
import com.kata.clientprofileauthentication.models.tokens.ProfileToken;
import com.kata.clientprofileauthentication.repository.tokenRepository.BlackListOfProfileTokensRepository;
import com.kata.clientprofileauthentication.repository.tokenRepository.ProfileTokenRepository;
import com.kata.clientprofileauthentication.service.tokenService.ProfileTokenManager;
import com.kata.clientprofileauthentication.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * сервис для работы со всеми токенами (рабочими и токенами из blacklist)
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProfileTokenManagerImpl implements ProfileTokenManager {
    private final BlackListOfProfileTokensRepository blackListOfProfileTokensRepository;
    private final ProfileTokenRepository profileTokenRepository;
    private final TokenUtils tokenUtils;
    /**
     * метод обновления ProfileToken (обновляется Bearer либо JwtBearer токены)
     * старые токены сохраняются в черном списке
     * @param bearerOrJwtBearerToken  - 1 из 2ух токенов
     * @return string
     */
    @Override
    public String updateToken(String bearerOrJwtBearerToken) {
        switch (getTokenType(bearerOrJwtBearerToken)) {
            case "Bearer " -> {
                ProfileToken updateProfileToken = profileTokenRepository
                        .getProfileTokenByBearerToken(bearerOrJwtBearerToken);
                log.info("Bearer токен найден");
                blackListOfProfileTokensRepository
                        .save(new BlackToken(updateProfileToken.getBearerToken()));
                log.info("Bearer токен занесен в черный список");
                updateProfileToken
                        .setBearerToken(tokenUtils.refreshTokens(bearerOrJwtBearerToken));
                log.info("Bearer токен обновлен");
                return updateProfileToken.getBearerToken();
            }
            case "JwtBearer " -> {
                ProfileToken updateProfileToken = profileTokenRepository
                        .getProfileTokensByJwtBearerToken(bearerOrJwtBearerToken);
                log.info("JwtBearer токен найден");
                blackListOfProfileTokensRepository
                        .save(new BlackToken(updateProfileToken.getJwtBearerToken()));
                log.info("JwtBearer токен занесен в черный список");
                updateProfileToken
                        .setJwtBearerToken(tokenUtils.refreshTokens(bearerOrJwtBearerToken));
                log.info("JwtBearer токен обновлен");
                return updateProfileToken.getJwtBearerToken();
            }
            default -> {
                return "Token incorrect";
            }
        }
    }
    /**
     * возвращает тип токена
     * @param bearerOrJwtBearerToken - 1 из 2ух токенов
     * @return - тип токена Bearer or JwtBearer
     */
    @Override
    public String getTokenType(String bearerOrJwtBearerToken) {
        if (bearerOrJwtBearerToken.startsWith("Bearer ")) {
            return "Bearer ";
        } else if (bearerOrJwtBearerToken.startsWith("JwtBearer ")) {
            return "JwtBearer ";
        } else {
            return "Incorrect";
        }
    }
}
