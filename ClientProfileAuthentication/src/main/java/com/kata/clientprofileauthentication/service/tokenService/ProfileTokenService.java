package com.kata.clientprofileauthentication.service.tokenService;

import com.kata.clientprofileauthentication.models.tokens.dto.BearerAndJwtBearerTokens;

public interface ProfileTokenService {
    boolean serviceValidateBearerOrJwtBearerToken(String token);
    BearerAndJwtBearerTokens generateMapNewTokens();
}
