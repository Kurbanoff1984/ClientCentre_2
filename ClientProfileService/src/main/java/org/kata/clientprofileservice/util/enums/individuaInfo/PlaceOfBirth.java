package org.kata.clientprofileservice.util.enums.individuaInfo;

public enum PlaceOfBirth {

    V1("Москва"),
    V2("Токио"),
    V3("Саратов"),
    V4("Мордор"),
    V5("Ярославль"),
    V6("Санкт Петербург"),
    V7("Сидней"),
    V8("Талдом"),
    V9("Дмитров"),
    V10("Лондон");
    private String value;
    private PlaceOfBirth(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
