package org.kata.clientprofileservice.util.enums.addressInfo;

public enum Street {

    V1("Главная улица"),
    V2("Высокая улица"),
    V3("Проспект Парка"),
    V4("Улица Вязов"),
    V5("Кленовая дорога"),
    V6("Дубовая аллея"),
    V7("Сосновая улица"),
    V8("Рыночная улица"),
    V9("Бродвей"),
    V10("Бульвар Заката");
    private String value;
    private Street(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
