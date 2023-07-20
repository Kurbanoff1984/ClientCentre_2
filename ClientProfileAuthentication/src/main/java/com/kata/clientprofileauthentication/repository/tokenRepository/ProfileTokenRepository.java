package com.kata.clientprofileauthentication.repository.tokenRepository;

import com.kata.clientprofileauthentication.models.tokens.ProfileToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileTokenRepository extends CrudRepository<ProfileToken, String> {
    ProfileToken getProfileTokenByBearerToken(String bearerToken);
    ProfileToken getProfileTokensByJwtBearerToken(String jwtBearerToken);
}