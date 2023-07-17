package org.kata.clientprofileservice.util.enums.individuaInfo;

public enum SurnameIndividual {

    V1("Иванов(а)"),
    V2("Перепелкин(а)"),
    V3("Соболев(а)"),
    V4("Ложка"),
    V5("Замай"),
    V6("Газизов(а)"),
    V7("Бэгинс"),
    V8("Еременко"),
    V9("Лутовинов(а)"),
    V10("Борисов(а)");
    private String value;
    private SurnameIndividual(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
