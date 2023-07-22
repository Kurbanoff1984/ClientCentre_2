package org.kata.clientprofileservice.util.enums.addressInfo;

public enum Province {
    V1("Московская область"),
    V2("Ленинградская область"),
    V3("Свердловская область"),
    V4("Республика Татарстан"),
    V5("Республика Башкортостан"),
    V6("Красноярский край"),
    V7("Республика Саха"),
    V8("Нижегородская область"),
    V9("Республика Дагестан"),
    V10("Пермский край");
    private String value;
    private Province(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
