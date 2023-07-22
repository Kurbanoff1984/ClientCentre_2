package org.kata.util.validation;


public class RegexForField {
    public static final String NAME_SURNAME_PATRONYMIC = "^[а-яА-ЯёЁ'\"\\- ]+$";
    public static final String PLACE_OF_BIRTH_ISSUED_BY = "^(?![-' ’\\. ])[а-яА-ЯёЁa-zA-Z\"'\\-\\. ](?:[а-яА-ЯёЁa-zA-Z\"'\\-\\. ]*)$";
    public static final String DATE = "^\\d{2}\\.\\d{2}\\.\\d{4}$";
    public static final String SNILS = "^\\d{3}-\\d{3}-\\d{3}\\s\\d{3}$";
    public static final String INN = "^\\d{12}$";
    public static final String NUMBER_RFP = "^\\d{6}$";
    public static final String SERIES_RFP = "^(?!00|02|06|13|16|21|23|31)\\d{2}\\s?\\d{2}$";
    public static final String DIVISION = "^(?!([0-9])\\1{2}-\\1{2})\\d{3}-\\d{3}$";
    public static final String ADDRESS_NAME = "^[а-яА-ЯёЁ0-9\\s\\-.,;:]+$";
    public static final String SERIES_FP = "^(?!80|81|82|83)\\b\\d{2}\\b$";
    public static final String NUMBER_FP = "^\\d{7}$";
    public static final String PHONE_NUMBER = "^7\\d{10}$";
    public static final String EMAIL = "^[A-Za-z0-9._%±]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
}
