package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.repository.AddressRepo;
import org.kata.clientprofileservice.service.AddressService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.AddressValidationDto;
import org.kata.entity.individual.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final ModelMapper modelMapper;
    private final AddressRepo addressRepo;
    @Override
    public void createAddress(AddressValidationDto addressValidationDto) {
        addressRepo.save(modelMapper.map(addressValidationDto, Address.class));
    }
}
