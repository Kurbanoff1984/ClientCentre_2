package org.kata.clientprofileservice.util.enums.addressInfo;

public enum Province {
    Alberta,
    BritishColumbia,
    Ontario,
    Quebec,
    Saskatchewan,
    Manitoba,
    NewfoundlandAndLabrador,
    NewBrunswick,
    NovaScotia,
    PrinceEdwardIsland;

    public String toStringProvince() {
        return this.name();
    }
}
