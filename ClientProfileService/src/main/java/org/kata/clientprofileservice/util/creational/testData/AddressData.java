package org.kata.clientprofileservice.util.creational.testData;

import org.kata.clientprofileservice.util.creational.abstractFactory.GeneratorAddressTestData;
import org.kata.clientprofileservice.util.enums.addressInfo.*;
import org.kata.clientprofileservice.util.enums.individuaInfo.CountryOfBirth;
import org.kata.clientprofileservice.util.enums.individuaInfo.PlaceOfBirth;
import org.kata.clientprofileservice.util.testDto.TestDataAddressDto;
import org.kata.entity.individual.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class AddressData implements GeneratorAddressTestData {
    private final List<CountryOfBirth> country = List.of(CountryOfBirth.values());
    private final List<PlaceOfBirth> city = List.of(PlaceOfBirth.values());
    private final List<StreetType> streetTypes = List.of(StreetType.values());
    private final List<CityType> cityTypes = List.of(CityType.values());
    private final List<Street> streets = List.of(Street.values());
    private final List<ProvinceType> provincesType = List.of(ProvinceType.values());
    private final List<Province> provinces = List.of(Province.values());
    private final List<Region> regions = List.of(Region.values());
    private final List<RegionType> regionsType = List.of(RegionType.values());
    private final List<SettlementType> settlementTypes = List.of(SettlementType.values());

    @Override
    public Address generateRandomAddress() {
        Random random = new Random();
        ModelMapper modelMapper = new ModelMapper();
        TestDataAddressDto address = TestDataAddressDto.builder()
                .country(country.get(random.nextInt(country.size())).toStringCountry())
                .city(city.get(random.nextInt(city.size())).toStringPlace())
                .streetType(streetTypes.get(random.nextInt(streetTypes.size())).toStringStreetType())
                .building(String.valueOf(random.nextInt(50)))
                .cityType(cityTypes.get(random.nextInt(cityTypes.size())).toStringCityType())
                .house(String.valueOf(random.nextInt(50)))
                .housing(String.valueOf(random.nextInt(20)))
                .street(streets.get(random.nextInt(streets.size())).toStringStreet())
                .zipCode(String.valueOf(random.nextInt(90000) + 10000))
                .provinceType(provincesType.get(random.nextInt(provincesType.size())).toStringProvince())
                .province(provinces.get(random.nextInt(provinces.size())).toStringProvince())
                .region(regions.get(random.nextInt(regions.size())).toStringRegion())
                .regionType(regionsType.get(random.nextInt(regionsType.size())).toStringRegionType())
                .settlement(String.valueOf(random.nextInt(50)))
                .settlementType(settlementTypes.get(random.nextInt(settlementTypes.size())).toStringSetType())
                .build();
        return modelMapper.map(address, Address.class);
    }
}
