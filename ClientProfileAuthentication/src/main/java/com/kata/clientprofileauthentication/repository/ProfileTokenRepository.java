package com.kata.clientprofilefacade1.repository;

import com.kata.clientprofilefacade1.models.ProfileToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileTokenRepository extends CrudRepository<ProfileToken, String> {
    ProfileToken getProfileTokenByBearerToken(String bearerToken);
    ProfileToken getProfileTokensByJwtBearerToken(String jwtBearerToken);
    boolean existsByBearerToken(String BearerToken);
    boolean existsByJwtBearerToken(String JwtBearerToken);

}