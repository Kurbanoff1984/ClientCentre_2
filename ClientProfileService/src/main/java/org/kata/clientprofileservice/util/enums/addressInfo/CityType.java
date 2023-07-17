package org.kata.clientprofileservice.util.enums.addressInfo;

public enum CityType {
    V1("Портовый"),
    V2("Город"),
    V3("Городок"),
    V4(" Деревня"),
    V5("Посёлок"),
    V6(" Пригород"),
    V7("Мегаполис"),
    V8("Столица"),
    V9("Курорт"),
    V10("Индустриальный");
    private String value;
    private CityType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
