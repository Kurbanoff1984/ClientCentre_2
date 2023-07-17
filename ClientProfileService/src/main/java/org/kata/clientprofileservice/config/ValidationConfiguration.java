package org.kata.clientprofileservice.config;

import org.kata.clientprofileservice.validation.fieldEntityValidation.*;
import org.kata.clientprofileservice.validation.fieldEntityValidation.Impl.*;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ValidationConfiguration {
    /**
     * validatorMap - содержит в ключе класс аннотации, в значении содержит класс-валидатор для текущей аннотации
     * @return Метод возвращающий объект класса AnnotationBasedParamValidatorImpl(класс запускающий валидацию)
     *      с инициализацией поля validationFunctions
     */
    @Bean
    public ParamValidator getParamValidator() {
        Map<Class<? extends Annotation>, FieldValidator> validatorMap = new LinkedHashMap<>();
        validatorMap.put(NotEmpty.class, new NotEmptyValidatorImpl());
        validatorMap.put(RegExp.class, new RegularExpressionValidatorImpl());
        validatorMap.put(GenderType.class, new GenderTypeValidationImpl());
        validatorMap.put(RelevanceDate.class, new DateValidationImpl());
        validatorMap.put(CheckDigitSnils.class, new SnilsDigitValidationImpl());
        validatorMap.put(CheckDigitINN.class, new INNDigitValidationImpl());
        return new AnnotationBasedParamValidatorImpl(validatorMap);
    }

}
