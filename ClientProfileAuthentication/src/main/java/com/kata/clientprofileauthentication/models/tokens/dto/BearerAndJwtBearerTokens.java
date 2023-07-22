package com.kata.clientprofileauthentication.models.tokens.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BearerAndJwtBearerTokens {
    private String bearerToken;
    private String jwtBearerToken;
}
