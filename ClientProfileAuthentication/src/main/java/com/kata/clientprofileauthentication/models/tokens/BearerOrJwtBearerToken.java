package com.kata.clientprofileauthentication.models.tokens;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BearerOrJwtBearerToken {
    private String bearerOrJwtBearerToken;
    @Override
    public String toString() {
        return bearerOrJwtBearerToken;
    }
}
