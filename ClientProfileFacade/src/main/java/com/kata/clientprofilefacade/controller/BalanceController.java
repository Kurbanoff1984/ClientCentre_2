package com.kata.clientprofilefacade.controller;

import com.kata.clientprofilefacade.service.FacadeGetBalanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller class can be used to get the user's balance
 */
@RestController
@AllArgsConstructor
public class BalanceController {

    private final FacadeGetBalanceService facadeGetBalanceService;

    /**
     * This method allows you to get the user's balance by icp
     */
    @GetMapping("/balance")
    public <T> ResponseEntity <T> getBalance(@RequestParam("icp") String icp, @RequestParam("currencies") String currencies)  {
        return facadeGetBalanceService.getBalance(icp, currencies);
    }
}
