package com.kata.clientprofilefacade.service.impl;

import com.kata.clientprofilefacade.dao.IndividualMaskDao;
import com.kata.clientprofilefacade.dto.IndividualDTO;
import com.kata.clientprofilefacade.service.IndividualMaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualMaskServiceImpl implements IndividualMaskService {

    private final IndividualMaskDao individualMaskDao;

    @Override
    public IndividualDTO maskName(IndividualDTO individual) {
        return individualMaskDao.maskName(individual);
    }
}
