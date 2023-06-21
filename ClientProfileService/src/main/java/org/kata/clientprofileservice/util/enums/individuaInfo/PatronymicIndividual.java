package org.kata.clientprofileservice.util.enums.individuaInfo;

public enum PatronymicIndividual {
    James,
    Mary,
    Elizabeth,
    Antonio,
    Sofia,
    Charles,
    Alexander,
    Rose,
    Thomas,
    Juan;

    public String toStringPatronymic() {
        return this.name();
    }

}
