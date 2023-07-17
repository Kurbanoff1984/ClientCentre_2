package org.kata.clientprofileservice.util.enums.individuaInfo;

public enum CountryOfBirth {
    V1("Россия"),
    V2("Греция"),
    V3("Австралия"),
    V4("Германия"),
    V5("США"),
    V6("Бразилия"),
    V7("Польша"),
    V8("Казахстан"),
    V9("Китай"),
    V10("Япония");
    private String value;
    private CountryOfBirth(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
