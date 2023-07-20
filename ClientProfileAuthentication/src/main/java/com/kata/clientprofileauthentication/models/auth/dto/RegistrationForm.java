package com.kata.clientprofileauthentication.models.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.NotEmpty;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.RegExp;
import org.kata.util.validation.RegexForField;

@Schema(description = "Входная форма регистрации")
@Getter
@Setter
public class RegistrationForm {

    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    @NotEmpty
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Имя пользователя", example = "Вася")
    private String name;

    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    @NotEmpty
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Фамилия пользователя", example = "Васильев")
    private String surname;

    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    @NotEmpty
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Отчество пользователя", example = "Васильевич")
    private String patronymic;
    @NotEmpty
    @RegExp(value = RegexForField.EMAIL)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Почта пользователя", example = "Vasia@mail.ru")
    private String email;

    @NotEmpty
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Наименование компании", example = "ООО \"Все хорошо!\"")
    private String company;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Цель посещения ресурса", example = "Для работы с документами клиентов")
    private String destination;
}

