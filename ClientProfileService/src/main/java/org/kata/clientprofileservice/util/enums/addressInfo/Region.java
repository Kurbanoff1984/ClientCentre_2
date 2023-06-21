package org.kata.clientprofileservice.util.enums.addressInfo;

public enum Region {
    PacificNorthwest,
    RockyMountains,
    GreatPlains,
    NewEngland,
    Midwest,
    Southwest,
    Southeast,
    DeepSouth,
    WestCoast,
    GulfCoast;

    public String toStringRegion() {
        return this.name();
    }
}
