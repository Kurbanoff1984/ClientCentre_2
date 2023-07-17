package org.kata.clientprofileservice.validation.fieldEntityValidation.Impl;



import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.validation.fieldEntityValidation.FieldValidator;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.RegExp;
import org.kata.util.validation.HashMapWithDescriptionRegex;

import java.lang.reflect.Field;
@Slf4j
public class RegularExpressionValidatorImpl implements FieldValidator {

    @Override
    public String validate(Object entity, Field field) {
        if (String.class.isAssignableFrom(field.getType())) {
            RegExp annotation = field.getAnnotation(RegExp.class);
            String regex = annotation.value();
            try {
                String fieldValue = (String) field.get(entity);
                if ((fieldValue != null) && !fieldValue.isEmpty() && !fieldValue.matches(regex)) {
                    HashMapWithDescriptionRegex hashMapWithRegex = new HashMapWithDescriptionRegex();
                    log.error("Field {} value does not match regular expression {}", field.getName(), regex);
                    return hashMapWithRegex.getRegex().get(field.getName());
                }
                log.info("The field {} value was successfully validated against the regular expression", field.getName());
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        }
        return "";
    }
}
