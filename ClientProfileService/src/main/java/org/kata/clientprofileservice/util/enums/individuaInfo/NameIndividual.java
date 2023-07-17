package org.kata.clientprofileservice.util.enums.individuaInfo;

public enum NameIndividual {
    V1("Александр"),
    V2("Сергей"),
    V3("Анна"),
    V4("Никита"),
    V5("Сэм"),
    V6("Фродо"),
    V7("Николай"),
    V8("Сергей"),
    V9("Светлана"),
    V10("Василий");
    private String value;
    private NameIndividual(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
