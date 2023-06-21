package org.kata.clientprofileservice.util.enums.addressInfo;

public enum CityType {
    City,
    Town,
    Village,
    Hamlet,
    Suburb,
    Metropolis,
    Capital,
    Resort,
    Industrial,
    PortCity;
    public String toStringCityType() {
        return this.name();
    }

}
