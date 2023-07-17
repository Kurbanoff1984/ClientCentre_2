package org.kata.clientprofileservice.validation.fieldEntityValidation.Impl;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.validation.fieldEntityValidation.FieldValidator;
import org.kata.util.validation.RegexForField;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Класс валидации полей birthOfDate по аннотации @RelevanceBirthDate
 */
@Slf4j
public class DateValidationImpl implements FieldValidator {
    /**
     * Использует общий класс валидации GeneralDateValidation для всех дат.
     * @param entity - объект требующий валидации (для получения значения поля field)
     * @param field - поле объекта entity требующее валидации
     * @return результат валидации в формате String
     */
    @Override
    public String validate(Object entity, Field field) {

        StringBuilder resultValidation = GeneralDateValidation.generalValidation(entity, field);
        try {
            String fieldValue = (String) field.get(entity);
            if ((fieldValue != null) && !fieldValue.isEmpty() && fieldValue.matches(RegexForField.DATE)) {
                int year = Integer.parseInt(fieldValue.split("\\.")[2]);
                SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
                inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date enterDate = inputFormat.parse(fieldValue);
                if (enterDate.compareTo(new Date()) >= 0) {
                    log.error("Incorrect entry of date of birth. The date  = {} is later than the current one.", fieldValue);
                    resultValidation.append("The date field cannot be later than the current date.");
                }
                if (year < 1900) {
                    log.error("Introduced a year before 1900 in date {}.", fieldValue);
                    resultValidation.append("The year cannot be lower than 1900");
                }
            }
            log.info("Success validation date = {}", fieldValue);
        } catch (IllegalAccessException | ParseException e) {
            throw new ValidationException(e);
        }
        return resultValidation.toString();
    }

}


