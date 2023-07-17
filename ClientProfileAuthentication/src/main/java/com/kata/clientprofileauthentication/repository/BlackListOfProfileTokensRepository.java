package com.kata.clientprofilefacade1.repository;

import com.kata.clientprofilefacade1.models.BlackListOfProfileTokens;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListOfProfileTokensRepository extends CrudRepository<BlackListOfProfileTokens, String> {
    boolean existsByBRefreshOrJwtOrBearer(String bRefreshOrJwtOrBearer);
}
