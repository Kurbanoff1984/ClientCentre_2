package org.kata.clientprofileservice.validation.fieldEntityValidation.Impl;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.kata.util.validation.RegexForField;

import java.lang.reflect.Field;
import java.time.Month;
import java.time.Year;

/**
 * Класс с логикой валидации - общей для всех дат:
 * 1. Соответствие регулярному выражению;
 * 2. Адекватность введенного номера месяца;
 * 3. Соответствие количества введенных дней номеру месяца.
 * Вызывается во всех классах валидации дат, имеющей специфичные требования к проверке.
 */
@Slf4j
public class GeneralDateValidation {
    /**
     *
     * @param entity
     * @param field
     * @return результат валидации в формате String
     */
    public static StringBuilder generalValidation(Object entity, Field field) {
        StringBuilder resultValidation;
        try {
            resultValidation = new StringBuilder();
            String fieldValue = (String) field.get(entity);
            if ((fieldValue != null) && !fieldValue.isEmpty() && fieldValue.matches(RegexForField.DATE)) {
                String[] dateParts = fieldValue.split("\\.");
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);
                if ((month  > 12) || (month < 1)) {
                    log.error("Invalid month number entered in date {}.", fieldValue);
                    resultValidation.append("Month number cannot be less than 0 and greater than 12.");
                    return resultValidation;
                }
                int maxDaysInMonth;
                if (Year.of(year).isLeap()) {
                    maxDaysInMonth = Month.of(month).minLength();
                } else {
                    maxDaysInMonth = Month.of(month).maxLength();
                }
                if (day > maxDaysInMonth) {
                    log.error("The specified day is outside the maximum number of days in a month in date {}.", fieldValue);
                    resultValidation.append("There are " + maxDaysInMonth + " in the month of " + Month.of(month) + " .");
                }
                log.info("Success validation date = {}", fieldValue);
            }
        } catch (IllegalAccessException e) {
            throw new ValidationException(e);
        }
        return resultValidation;

    }

}
