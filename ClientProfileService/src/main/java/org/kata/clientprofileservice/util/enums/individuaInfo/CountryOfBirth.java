package org.kata.clientprofileservice.util.enums.individuaInfo;

public enum CountryOfBirth {

    Greece,
    Australia,
    Brazil,
    Canada,
    Italy,
    Norway,
    Japan,
    Korea,
    Morocco,
    Africa;

    public String toStringCountry() {
        return this.name();
    }

}
