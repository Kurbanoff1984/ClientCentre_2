package com.kata.clientprofileauthentication.service.tokenService.tokenServiceImpl;

import com.kata.clientprofileauthentication.models.tokens.dto.BearerAndJwtBearerTokens;
import com.kata.clientprofileauthentication.repository.tokenRepository.ProfileTokenRepository;
import com.kata.clientprofileauthentication.service.tokenService.ProfileTokenService;
import com.kata.clientprofileauthentication.util.JwtTokenGenerator;
import com.kata.clientprofileauthentication.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * сервис для работы с рабочими токенами
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class ProfileTokenServiceImpl implements ProfileTokenService {
    private final ProfileTokenRepository profileTokenRepository;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final TokenUtils tokenUtils;
    private final ModelMapper modelMapper;

    /**
     * сервис валидации токенов
     * @param tokenType - 1 из 2ух токенов
     * @return //
     */
    @Override
    public boolean serviceValidateBearerOrJwtBearerToken(String tokenType) {
        switch (tokenType) {
            case "Bearer " -> {
                return tokenUtils.validateRefreshTokenByJwtBearerOrBearerToken
                        (profileTokenRepository.getProfileTokenByBearerToken(tokenType));
            }
            case "JwtBearer " -> {
                return tokenUtils.validateRefreshTokenByJwtBearerOrBearerToken
                        (profileTokenRepository.getProfileTokensByJwtBearerToken(tokenType));
            }
            default -> {
                return false;
            }
        }
    }
    /**
     * генерация нового ProfileToken и мап на BearerAndJwtBearerTokens
     * @return //
     */
    @Override
    public BearerAndJwtBearerTokens generateMapNewTokens() {
        log.info(jwtTokenGenerator.generateAllTokens().toString());
        log.info(jwtTokenGenerator.generateAllTokens().toString());
        return modelMapper.map(profileTokenRepository
                                .save(jwtTokenGenerator.generateAllTokens()), BearerAndJwtBearerTokens.class);
    }
}
