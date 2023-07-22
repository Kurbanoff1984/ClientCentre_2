package org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Проверка на соответствие поля регулярному выражению
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RegExp {
    /**
     * @return возвращает параметры переданные в аннотацию (в данном случае - регулярное выражение)
     */
    String value();
}
