package com.kata.clientprofileauthentication.service.tokenService.tokenServiceImpl;

import com.kata.clientprofileauthentication.repository.tokenRepository.BlackListOfProfileTokensRepository;
import com.kata.clientprofileauthentication.service.tokenService.BlackProfileTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * сервис для работы с blacklist токенами
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BlackProfileTokenServiceImpl implements BlackProfileTokenService {
    private final BlackListOfProfileTokensRepository blackListOfProfileTokensRepository;
    /**
     * метод проверяет есть ли токены из параметров в черном списке
     * @param bearerOrJwtBearerToken 1 из 2ух видов токенов
     * @return //
     */
    @Override
    public boolean findBlackTokens(String bearerOrJwtBearerToken) {
        return blackListOfProfileTokensRepository
                .existsByBlackToken(bearerOrJwtBearerToken);
    }
}
