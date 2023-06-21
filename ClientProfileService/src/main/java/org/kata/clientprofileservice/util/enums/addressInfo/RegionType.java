package org.kata.clientprofileservice.util.enums.addressInfo;

public enum RegionType {
    AdministrativeRegion,
    GeographicRegion,
    CulturalRegion,
    EconomicRegion,
    TouristRegion,
    RuralRegion,
    UrbanRegion,
    CoastalRegion,
    MountainousRegion,
    BorderRegion;

    public String toStringRegionType() {
        return this.name();
    }
}
