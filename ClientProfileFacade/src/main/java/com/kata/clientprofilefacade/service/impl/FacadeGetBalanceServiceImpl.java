package com.kata.clientprofilefacade.service.impl;

import com.kata.clientprofilefacade.dao.FacadeGetBalanceDao;
import com.kata.clientprofilefacade.service.FacadeGetBalanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FacadeGetBalanceServiceImpl implements FacadeGetBalanceService {

    private final FacadeGetBalanceDao facadeGetBalanceDao;
    @Override
    public <T> ResponseEntity<T> getBalance(String icp, String currencies) {
        return facadeGetBalanceDao.getBalance(icp, currencies);
    }
}
