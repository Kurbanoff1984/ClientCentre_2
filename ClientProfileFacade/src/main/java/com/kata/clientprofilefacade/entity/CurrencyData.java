package com.kata.clientprofilefacade.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CurrencyData {

    private Meta meta;
    private Map<String, Currency> data;
}
