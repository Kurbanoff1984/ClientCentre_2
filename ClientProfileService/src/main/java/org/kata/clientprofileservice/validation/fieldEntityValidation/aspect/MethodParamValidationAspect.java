package org.kata.clientprofileservice.validation.fieldEntityValidation.aspect;

import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.kata.clientprofileservice.validation.fieldEntityValidation.ParamValidator;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Класс аспект для внедрения функциональности валидации параметров перед выполнением методов
 */
@Aspect
@Component
@AllArgsConstructor
public class MethodParamValidationAspect {
    private final ParamValidator validator;

    /**
     * @param joinPoint - информация о методе (сигнатура) над которым проставлена аннотация @ValidParams
     * Создает поток из параметров метода и применяет к каждому элементу механизм валидации
     */
    @Before(value = "@annotation(org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.ValidParams)")
    public void validateParameters(JoinPoint joinPoint) {
        Stream.of(joinPoint.getArgs()).forEach(validator::validate);
    }
}
