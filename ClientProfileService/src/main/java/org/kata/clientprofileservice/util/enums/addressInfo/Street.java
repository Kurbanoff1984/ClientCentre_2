package org.kata.clientprofileservice.util.enums.addressInfo;

public enum Street {
    MainStreet,
    HighStreet,
    ParkAvenue,
    ElmStreet,
    MapleRoad,
    OakLane,
    PineStreet,
    MarketStreet,
    Broadway,
    SunsetBoulevard;

    public String toStringStreet() {
        return this.name();
    }
}
