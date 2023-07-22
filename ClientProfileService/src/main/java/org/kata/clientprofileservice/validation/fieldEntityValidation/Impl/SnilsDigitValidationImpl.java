package org.kata.clientprofileservice.validation.fieldEntityValidation.Impl;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.validation.fieldEntityValidation.FieldValidator;
import org.kata.util.validation.RegexForField;

import java.lang.reflect.Field;
import java.util.stream.IntStream;

/**
 * Класс валидации поля snils по аннотации @CheckDigitSnils
 */
@Slf4j
public class SnilsDigitValidationImpl implements FieldValidator {
    /**
     * Выполняется проверка на валидность snils путем вычисления контрольного числа и сравнением его с двумя младшими разрядами snils
     * @param entity - объект требующий валидации (для получения значения поля field)
     * @param field - поле объекта entity требующее валидации
     * @return результат валидации в формате String
     * @see <a href="https://ru.wikipedia.org/wiki/Контрольное_число">Алгоритм вычисления контрольного числа</a>
     */
    @Override
    public String validate(Object entity, Field field) {
        int checkDigit = 0;
        try {
            String fieldValue = (String) field.get(entity);
            if ((fieldValue != null) && !fieldValue.isEmpty() && fieldValue.matches(RegexForField.SNILS)) {
                int[] digitIntArray = fieldValue.chars()
                        .filter(Character::isDigit)
                        .map(Character::getNumericValue)
                        .limit(9)
                        .toArray();
                int checkSum =  IntStream.range(0, 9)
                        .map(i -> digitIntArray[i] * (9 - i))
                        .sum();
                if (checkSum < 100) {
                    checkDigit = checkSum;
                } else if (checkSum > 100) {
                    if ((checkSum % 101) != 100) {
                        checkDigit = checkSum % 101;
                    }
                }
                int lastTwoRanks = Integer.parseInt(fieldValue.substring(fieldValue.length() - 2));
                if (lastTwoRanks != checkDigit) {
                    log.error("Inconsistency of the entered SNILS {} with the checksum {}.", fieldValue, checkDigit);
                    return "Checksum verification failed";
                }
                log.info("Successful field validation {}; value = {}, check digit = {} ", field.getName(), fieldValue, checkDigit);
            }
        } catch (IllegalAccessException e) {
            throw new ValidationException(e);
        }
        return "";
    }
}
