package org.kata.clientprofileservice.validation.fieldEntityValidation.Impl;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.validation.fieldEntityValidation.FieldValidator;
import org.kata.clientprofileservice.validation.fieldEntityValidation.ParamValidator;
import org.kata.exception.validationException.ComplexValidationException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Реализация ParamValidator, класс, который запускает валидацию.
 * Создание Bean'a и инициализация validationFunctions осуществляется в ValidationConfiguration.
 * Внедряется в MethodParamValidationAspect
 */
@Slf4j
public class AnnotationBasedParamValidatorImpl implements ParamValidator {
    /** Справочник содержащий:
     * ключ - аннотация для валидации (из пакета validationAnnotation)
     * значение - класс-валидатор для аннотации*/
    private final Map<Class<? extends Annotation>, FieldValidator> validationFunctions;


    /**Содержит все доступные аннотации для валидации*/
    private final Set<Class<? extends Annotation>> supportedFieldAnnotations;

    public AnnotationBasedParamValidatorImpl(Map<Class<? extends Annotation>, FieldValidator> validationFunctions) {
        this.validationFunctions = validationFunctions;
        supportedFieldAnnotations = this.validationFunctions.keySet();
    }

    /**
     * Валидация считается неуспешной, если объект errorsOrOk содержит элементы (результаты валидации отличные от пустой строки (""))
     * @param param - объект для проверки на валидность
     */
    @Override
    public void validate(Object param) {
        log.debug("Start of object validation {}", param);
        if (param == null) {
            log.error("Validated object is null");
            throw new ValidationException("Passed param is null");
        }
        Map<String, String> complexInfo = new LinkedHashMap<>();
        Field[] declaredFields = param.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            List<String> errorsOrOk = new ArrayList<>(supportedFieldAnnotations.stream()
                    .filter(field::isAnnotationPresent)
                    .map(annotation -> validationFunctions.get(annotation).validate(param, field))
                    .toList());
            errorsOrOk.removeIf(String::isEmpty);
            if (!errorsOrOk.isEmpty()) {
                complexInfo.put(field.getName(), String.join(" ", errorsOrOk));
            }
        }
        if (!complexInfo.isEmpty()) {
            log.error("Object {} validation failed", param);
            throw new ComplexValidationException(complexInfo);
        }
        log.info("Validation was successful for the object {}", param);
    }
}
