package com.kata.clientprofileauthentication.service.tokenService;

public interface ProfileTokenManager {
    String getTokenType(String bearerOrJwtBearerToken);
    Object updateToken(String bearerOrJwtBearerToken);
}
