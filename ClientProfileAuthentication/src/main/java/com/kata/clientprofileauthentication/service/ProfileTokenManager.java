package com.kata.clientprofilefacade1.service;

import com.kata.clientprofilefacade1.models.BearerOrJwtBearerToken;
import com.kata.clientprofilefacade1.models.ProfileToken;

public interface ProfileTokenManager {
    ProfileToken updateProfileToken(BearerOrJwtBearerToken bearerOrJwtBearerToken);
    String getTokenType(String bearerOrJwtBearerToken);
}
