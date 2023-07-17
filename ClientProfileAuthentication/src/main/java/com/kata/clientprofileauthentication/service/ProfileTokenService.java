package com.kata.clientprofilefacade1.service;

import com.kata.clientprofilefacade1.models.ProfileToken;

public interface ProfileTokenService {
    ProfileToken generateNewAllTokenServiceImpl();
    boolean findBearerTokenBool(String bearerToken);
    boolean findJwtBearerTokenBool(String jwtBearerToken);
    boolean serviceValidateBearerOrJwtBearerToken(String token);
    boolean findTokenBool(String tokenType, String bearerOrJwtBearerToken);
}
