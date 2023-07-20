package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.repository.AddressRepo;
import org.kata.clientprofileservice.service.AddressService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.AddressValidationDto;
import org.kata.dto.response.AddressResponseDto;
import org.kata.entity.individual.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final ModelMapper modelMapper;
    private final AddressRepo addressRepo;
    @Override
    public void createAddress(AddressValidationDto addressValidationDto) {
        addressRepo.save(modelMapper.map(addressValidationDto, Address.class));
    }

    @Override
    public AddressResponseDto getAddress(String icp) {
        Optional<Address> address = addressRepo.findByUserIcp(icp);
        return address.map(value -> modelMapper.map(value, AddressResponseDto.class)).orElse(null);
    }
}
