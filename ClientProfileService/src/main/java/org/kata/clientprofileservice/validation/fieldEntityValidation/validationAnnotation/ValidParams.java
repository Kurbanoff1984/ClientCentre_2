package org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Проставляется над методами, входные параметры которого требуют валидации
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidParams {

}
