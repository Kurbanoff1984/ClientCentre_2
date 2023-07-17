package org.kata.clientprofileservice.util.enums.addressInfo;

public enum StreetType {
    V1("Высокая улица"),
    V2("Главная улица"),
    V3("Авеню"),
    V4("Бульвар"),
    V5("Переулок"),
    V6("Дорога"),
    V7("Площадь"),
    V8("Тупик"),
    V9("Променад"),
    V10("Аллея");
    private String value;
    private StreetType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}







