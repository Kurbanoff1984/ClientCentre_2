package org.kata.clientprofileservice.util.enums.addressInfo;

public enum RegionType {
    V1("Административный регион"),
    V2("Географический регион"),
    V3("Культурный регион"),
    V4("Экономический регион"),
    V5("Туристический регион"),
    V6("Сельский регион"),
    V7("Городской регион"),
    V8("Прибрежный регион"),
    V9(" Горный регион"),
    V10("Пограничный регион");
    private String value;
    private RegionType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
