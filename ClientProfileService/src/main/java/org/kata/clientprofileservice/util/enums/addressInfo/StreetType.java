package org.kata.clientprofileservice.util.enums.addressInfo;

public enum StreetType {
    HighStreet,
    MainStreet,
    Avenue,
    Boulevard,
    Lane,
    Road,
    Square,
    CulDeSac,
    Promenade,
    Alley;
    public String toStringStreetType() {
        return this.name();
    }
}
