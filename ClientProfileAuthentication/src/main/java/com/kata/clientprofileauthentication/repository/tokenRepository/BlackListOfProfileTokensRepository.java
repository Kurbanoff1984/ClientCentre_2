package com.kata.clientprofileauthentication.repository.tokenRepository;

import com.kata.clientprofileauthentication.models.tokens.BlackToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListOfProfileTokensRepository extends CrudRepository<BlackToken, String> {
    boolean existsByBlackToken(String blackToken);
}
