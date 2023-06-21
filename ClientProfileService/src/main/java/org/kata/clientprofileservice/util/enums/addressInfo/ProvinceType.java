package org.kata.clientprofileservice.util.enums.addressInfo;

public enum ProvinceType {
    AdministrativeProvince,
    HistoricalProvince,
    GeographicalProvince,
    AutonomousProvince,
    EconomicProvince,
    CoastalProvince,
    LandlockedProvince,
    Not;

    public String toStringProvince() {
        return this.name();
    }
}
