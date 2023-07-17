package com.kata.clientprofilefacade.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BalanceAccountDTO {

    private String icp;
    private double balanceRub;
    private double balanceUsd;
    private double balanceEur;
}
