package org.kata.clientprofileservice.util.testDto;

import lombok.*;
import org.kata.entity.individual.Individual;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDataAddressDto {

    private String uuid;
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
    private Individual individual;

}
