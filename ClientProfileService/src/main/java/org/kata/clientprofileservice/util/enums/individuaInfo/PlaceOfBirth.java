package org.kata.clientprofileservice.util.enums.individuaInfo;

public enum PlaceOfBirth {
    London,
    NewYorkCity,
    Sydney,
    Tokyo,
    Paris,
    Dubai,
    LosAngeles,
    Berlin,
    Toronto,
    Rome;

    public String toStringPlace() {
        return this.name();
    }
}
