package org.kata.clientprofileservice.util.enums.addressInfo;

public enum SettlementType {
    V1("Номер квартиры"),
    V2("Этаж"),
    V3("Название здания"),
    V4("Почтовый ящик"),
    V5("Сельский маршрут"),
    V6("Частная дорога"),
    V7("Перекресток"),
    V8("Ориентир"),
    V9("Почтовый индекс"),
    V10("Инструкции по доставке");
    private String value;
    private SettlementType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
