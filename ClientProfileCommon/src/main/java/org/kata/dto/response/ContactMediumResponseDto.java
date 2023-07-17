package org.kata.dto.response;

import lombok.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactMediumResponseDto {

    private Collection<EmailResponseDto> emails;

    private Collection<PhoneNumberResponseDto> phoneNumbers;
}
