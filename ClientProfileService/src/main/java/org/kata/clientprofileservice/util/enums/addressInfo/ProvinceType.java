package org.kata.clientprofileservice.util.enums.addressInfo;

public enum ProvinceType {
    V1("Административная провинция"),
    V2("Историческая провинция"),
    V3("Географическая провинция"),
    V4("Автономная провинция"),
    V5("Экономическая провинция"),
    V6("Прибрежная провинция"),
    V7("Внутренняя провинция");

    private String value;
    private ProvinceType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
