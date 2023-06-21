package org.kata.clientprofileservice.util.enums.addressInfo;

public enum SettlementType {
    ApartmentSuiteUnitNumber,
    FloorLeve,
    BuildingName,
    POBox,
    RuralRoute,
    PrivateRoad,
    CrossStreet,
    Landmark,
    PostalCode,
    DeliveryInstructions;

    public String toStringSetType() {
        return this.name();
    }
}
