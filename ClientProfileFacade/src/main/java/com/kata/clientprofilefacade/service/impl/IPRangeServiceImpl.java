package com.kata.clientprofilefacade.service.impl;

import com.kata.clientprofilefacade.repository.IPRangeRepository;
import com.kata.clientprofilefacade.service.IPRangeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class IPRangeServiceImpl implements IPRangeService {

    private final IPRangeRepository ipRangeRepository;

    @Override
    public Optional<String> findCityByIpAddress(String ipAddress) {
        return ipRangeRepository.findCityByIpAddress(ipAddress);
    }
}
