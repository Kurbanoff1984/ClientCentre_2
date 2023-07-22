package com.kata.clientprofilefacade.service;

import org.springframework.http.ResponseEntity;

public interface FacadeGetBalanceService {
    <T> ResponseEntity<T> getBalance(String icp, String currencies);
}
