package com.kata.clientprofilefacade.service;


import java.util.Optional;

public interface IPRangeService {
    Optional<String> findCityByIpAddress(String ipAddress);
}
