package org.kata.clientprofileservice.validation.fieldEntityValidation;

import java.lang.reflect.Field;

/**
 * Интерфейс валидации полей объекта
 */
public interface FieldValidator {
    /**
     * @param entity - объект требующий валидации (для получения значения поля field)
     * @param field - поле объекта entity требующее валидации
     */

    String validate(Object entity, Field field);
}
