package com.kata.clientprofilefacade1.service;

import com.kata.clientprofilefacade1.models.BearerOrJwtBearerToken;

public interface BlackProfileTokenService {
    boolean findBlackTokens(BearerOrJwtBearerToken bearerOrJwtBearerToken);
}
