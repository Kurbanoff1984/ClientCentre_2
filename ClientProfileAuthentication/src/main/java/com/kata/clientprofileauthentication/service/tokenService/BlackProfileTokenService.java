package com.kata.clientprofileauthentication.service.tokenService;

public interface BlackProfileTokenService {
    boolean findBlackTokens(String bearerOrJwtBearerToken);
}
