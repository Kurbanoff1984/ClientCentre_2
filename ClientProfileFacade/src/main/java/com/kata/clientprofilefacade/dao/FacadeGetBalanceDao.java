package com.kata.clientprofilefacade.dao;

import org.springframework.http.ResponseEntity;

public interface FacadeGetBalanceDao {
    <T> ResponseEntity<T> getBalance(String icp, String currencies);
}
