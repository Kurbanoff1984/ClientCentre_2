package org.kata.clientprofileservice.validation.fieldEntityValidation.Impl;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.validation.fieldEntityValidation.FieldValidator;

import java.lang.reflect.Field;
import java.util.Collection;
@Slf4j
public class NotEmptyValidatorImpl implements FieldValidator {

    @Override
    public String validate(Object entity, Field field) {
        try  {
            if (Collection.class.isAssignableFrom(field.getType())) {
                Collection<?> fieldValue = (Collection<?>) field.get(entity);
                if (fieldValue == null || fieldValue.isEmpty()) {
                    log.error("An empty or null field value was passed. Field - {}", field.getName());
                    return "Field must not be empty.";
                }
            } else if (String.class.isAssignableFrom(field.getType())) {
                String fieldValue = (String) field.get(entity);
                if (fieldValue == null || fieldValue.isEmpty()) {
                    log.error("An empty or null field value was passed. Field - {}", field.getName());
                    return "Field must not be empty.";
                }
            } else {
                if  (field.get(entity) == null) {
                    log.error("An empty or null field value was passed. Field - {}", field.getName());
                    return "Field must not be empty.";
                }
            }
            log.info("The field {} successfully passed the test for null/emptiness.", field.getName());
        } catch (IllegalAccessException e) {
            throw new ValidationException(e);
        }
        return "";
    }
}
