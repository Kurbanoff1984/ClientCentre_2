package org.kata.clientprofileservice.validation.fieldEntityValidation.Impl;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.validation.fieldEntityValidation.FieldValidator;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.GenderType;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
@Slf4j
public class GenderTypeValidationImpl implements FieldValidator {
    @Override
    public String validate(Object entity, Field field) {
        GenderType annotation = field.getAnnotation(GenderType.class);
        List<String> genders = Arrays.stream(annotation.gender()).toList();
        try {
            String fieldValue = (String) field.get(entity);
            if (!(fieldValue == null) && !fieldValue.isEmpty() && !genders.contains(fieldValue)) {
                log.error("Wrong gender specified - {}", fieldValue);
                return "None of the allowed values were selected in the field. Valid options " + genders.toString().replace("[", "").replace("]", "") + ". ";
            }
            log.info("The gender field was successfully validated - {}.", fieldValue);
        } catch (IllegalAccessException e) {
            throw new ValidationException(e);
        }
        return "";
    }
}
