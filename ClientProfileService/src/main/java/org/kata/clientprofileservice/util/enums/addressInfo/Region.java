package org.kata.clientprofileservice.util.enums.addressInfo;

public enum Region {
    V1("Московская область"),
    V2("Санкт Петербург"),
    V3("Краснодарский край"),
    V4("Татарстан"),
    V5("Свердловская область"),
    V6("Ростовская область"),
    V7("Башкортостан"),
    V8("Нижегородская область"),
    V9("Пермский край"),
    V10("Самарская область");
    private String value;
    private Region(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
