package org.kata.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressResponseDto {

    private String addressName;
    private String country;
    private String zipCode;
    private String province;
    private String provinceType;
    private String region;
    private String regionType;
    private String city;
    private String cityType;
    private String settlement;
    private String settlementType;
    private String street;
    private String streetType;
    private String additionAreaStreet;
    private String house;
    private String housing;
    private String building;
}
