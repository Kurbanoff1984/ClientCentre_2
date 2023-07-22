package org.kata.clientprofileservice.util.enums.individuaInfo;

public enum PatronymicIndividual {

    V1("Алексеевич(вна)"),
    V2("Владимирович(вна)"),
    V3("Сергеевич(вна)"),
    V4("Николаевич(вна)"),
    V5("Александрович(вна)"),
    V6("Максимович(вна)"),
    V7("Кириллович(вна)"),
    V8("NOT"),
    V9("Андреевич(вна)"),
    V10("Олегович(вна)");
    private String value;
    private PatronymicIndividual(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
