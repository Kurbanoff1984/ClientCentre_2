package org.kata.clientprofileservice.service;

import org.kata.dto.response.ContactMediumResponseDto;

public interface ContactMediumService {
    ContactMediumResponseDto getContactMedium(String icp);
}
