package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.repository.ContactMediumRepo;
import org.kata.clientprofileservice.service.ContactMediumService;
import org.kata.dto.response.ContactMediumResponseDto;
import org.kata.entity.contactmedium.ContactMedium;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {

    private final ContactMediumRepo contactMediumRepo;
    private final ModelMapper modelMapper;
    @Override
    public ContactMediumResponseDto getContactMedium(String icp) {
        Optional<ContactMedium> contactMedium = contactMediumRepo.findAllByUserIcp(icp);
        return contactMedium.map(value -> modelMapper.map(value, ContactMediumResponseDto.class)).orElse(null);
    }
}
