package com.kata.clientprofilefacade1.service.serviceImpl;

import com.kata.clientprofilefacade1.models.ProfileToken;
import com.kata.clientprofilefacade1.repository.ProfileTokenRepository;
import com.kata.clientprofilefacade1.service.ProfileTokenService;
import com.kata.clientprofilefacade1.util.JwtTokenGenerator;
import com.kata.clientprofilefacade1.util.SecureUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * сервис для работы с рабочими токенами
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProfileTokenServiceImpl implements ProfileTokenService {
    private final ProfileTokenRepository profileTokenRepository;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final SecureUtils secureUtils;

    @Override
    public ProfileToken generateNewAllTokenServiceImpl() {
        return profileTokenRepository.save(jwtTokenGenerator.generateAllTokens());
    }

    @Override
    public boolean findBearerTokenBool(String bearerToken) {
        return profileTokenRepository.existsByBearerToken(bearerToken);
    }
    @Override
    public boolean findJwtBearerTokenBool(String jwtBearerToken) {
        return profileTokenRepository.existsByJwtBearerToken(jwtBearerToken);
    }

    @Override
    public boolean serviceValidateBearerOrJwtBearerToken(String token) {
        if (token.startsWith("Bearer ")) {
            return secureUtils.validateRefreshTokenByJwtBearerOrBearerToken
                    (profileTokenRepository.getProfileTokenByBearerToken(token));
        } else {
            return secureUtils.validateRefreshTokenByJwtBearerOrBearerToken
                    (profileTokenRepository.getProfileTokensByJwtBearerToken(token));
        }
    }

    @Override
    public boolean findTokenBool(String tokenType, String bearerOrJwtBearerToken) {
        if (tokenType.startsWith("Bearer ")) {
            return profileTokenRepository.existsByBearerToken(bearerOrJwtBearerToken);
        } else {
            return profileTokenRepository.existsByJwtBearerToken(bearerOrJwtBearerToken);
        }
    }
}
