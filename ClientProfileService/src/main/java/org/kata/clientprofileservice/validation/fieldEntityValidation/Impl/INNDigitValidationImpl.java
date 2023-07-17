package org.kata.clientprofileservice.validation.fieldEntityValidation.Impl;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.validation.fieldEntityValidation.FieldValidator;
import org.kata.util.validation.RegexForField;

import java.lang.reflect.Field;
import java.util.stream.IntStream;

/**
 * Класс валидации для поля inn по аннотации @CheckDigitINN
 */
@Slf4j
public class INNDigitValidationImpl implements FieldValidator {
    /**
     * Выполняется проверка на валидность inn путем вычисления двух контрольных чисел и сравнения их с двумя младшими разрядами INN соответственно
     * @param entity - объект требующий валидации (для получения значения поля field)
     * @param field - поле объекта entity требующее валидации
     * @return результат валидации в формате String
     * @see <a href="https://ru.wikipedia.org/wiki/Контрольное_число">Алгоритм вычисления контрольных чисел</a>
     */
    @Override
    public String validate(Object entity, Field field) {

        try {
            int[] coefficientForFirstDigit = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
            int[] coefficientForSecondDigit = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
            String fieldValue = (String) field.get(entity);
            if ((fieldValue != null) && !fieldValue.isEmpty() && fieldValue.matches(RegexForField.INN)) {
                int[] arrayFieldValue = fieldValue.chars()
                        .map(Character::getNumericValue)
                        .toArray();
                int firstDigitSum = IntStream.range(0, arrayFieldValue.length - 2)
                        .map(i -> arrayFieldValue[i] * coefficientForFirstDigit[i])
                        .sum();
                int secondDigitSum = IntStream.range(0, arrayFieldValue.length - 1)
                        .map(i -> arrayFieldValue[i] * coefficientForSecondDigit[i])
                        .sum();
                if (!(((firstDigitSum % 11) % 10) == arrayFieldValue[10]) || !(((secondDigitSum % 11) % 10) == arrayFieldValue[11])) {
                    log.error("INN {} did not pass check digits, first check digit - {}, second check digit - {}.",
                            fieldValue,
                            (firstDigitSum % 11) % 10,
                            (secondDigitSum % 11) % 10);
                    return "Incorrect INN entered.";
                }
                log.info("Successful verification of INN. INN - {}, first check digit - {}, second check digit - {}",
                        fieldValue,
                        (firstDigitSum % 11) % 10,
                        (secondDigitSum % 11) % 10);
            }
        } catch (IllegalAccessException e) {
            throw new ValidationException(e);
        }
        return "";
    }
}
