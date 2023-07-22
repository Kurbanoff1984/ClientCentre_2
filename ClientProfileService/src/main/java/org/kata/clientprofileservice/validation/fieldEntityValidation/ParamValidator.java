package org.kata.clientprofileservice.validation.fieldEntityValidation;

import java.util.List;

/**
 * Интерфейс валидации объектов, реализуется посредством AnnotationBasedParamValidatorImpl
 */
public interface ParamValidator {
    /**
     * @param object - объект для проверки на валидность (принимает объекты в параметрах метода)
     */
    void validate(Object object);

}
