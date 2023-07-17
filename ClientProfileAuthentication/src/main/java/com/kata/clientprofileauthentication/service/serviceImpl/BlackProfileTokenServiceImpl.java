package com.kata.clientprofilefacade1.service.serviceImpl;

import com.kata.clientprofilefacade1.models.BearerOrJwtBearerToken;
import com.kata.clientprofilefacade1.repository.BlackListOfProfileTokensRepository;
import com.kata.clientprofilefacade1.service.BlackProfileTokenService;
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

    @Override
    public boolean findBlackTokens(BearerOrJwtBearerToken bearerOrJwtBearerToken) {
        if (bearerOrJwtBearerToken.getBearerOrJwtBearerToken().startsWith("Bearer ")) {
            return blackListOfProfileTokensRepository
                    .existsByBRefreshOrJwtOrBearer(bearerOrJwtBearerToken.getBearerOrJwtBearerToken());
        } else if (bearerOrJwtBearerToken.getBearerOrJwtBearerToken().startsWith("JwtBearer ")) {
            return blackListOfProfileTokensRepository
                    .existsByBRefreshOrJwtOrBearer(bearerOrJwtBearerToken.getBearerOrJwtBearerToken());
        }
        return false;
    }
}
