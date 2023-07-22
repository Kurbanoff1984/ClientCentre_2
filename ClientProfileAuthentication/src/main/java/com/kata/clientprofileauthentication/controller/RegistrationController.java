package com.kata.clientprofileauthentication.controller;

import com.kata.clientprofileauthentication.models.auth.dto.AuthLoginAndPassword;
import com.kata.clientprofileauthentication.models.auth.dto.Message;
import com.kata.clientprofileauthentication.models.auth.dto.RegistrationForm;
import com.kata.clientprofileauthentication.service.tokenService.tokenServiceImpl.ProfileTokenServiceImpl;
import com.kata.clientprofileauthentication.service.secureService.RegistrationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.ValidParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * контроллер регистрации и аутентификации
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
@Tag(name = "Контроллер", description = "Все методы для работы c аутентификацией и регистрацией")
public class  RegistrationController {
    private final ProfileTokenServiceImpl profileTokenServiceImpl;
    private final RegistrationServiceImpl registrationServiceImpl;
    /**
     * метод принимает форму регистрации и возвращает сгенерированный логин и пароль
     * @param registrationForm - входная форма регистрации
     * @return - возвращает логин и пароль
     */
    @Operation(summary = "Регистрация пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = RegistrationForm.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping("/registration")
    @ValidParams
    public ResponseEntity<?> ClientProfileRegistration(
           @RequestBody RegistrationForm registrationForm) {
        if (registrationServiceImpl.inputFormToCheck(registrationForm)) {
            log.warn("Данный пользователь уже существует");
            return ResponseEntity.badRequest()
                    .body(new Message("Данный пользователь уже существует"));
        }
        return ResponseEntity.ok()
                .body(registrationServiceImpl.generateLogAndPass(registrationForm));
    }

    /**
     * метод принимает на вход логин и пароль, и в случае успеха возвращает пару токенов
     * @param authLoginAndPassword - форма логина и пароля
     * @return - возвращает пару логинов и паролей
     */
    //все в теле
    @Operation(summary = "Аутентификация пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = AuthLoginAndPassword.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(defaultValue = "Логин или пароль неверен")) }),
            @ApiResponse(responseCode = "500", content =
                    { @Content(schema = @Schema()) }) })
    @PostMapping("/authentication")
    public ResponseEntity<?> ClientProfileAuthentication(
            @RequestBody AuthLoginAndPassword authLoginAndPassword) {
        if (!registrationServiceImpl.authenticatedFlagCheck(authLoginAndPassword) &&
                registrationServiceImpl.authenticationCheck(authLoginAndPassword)) {
            log.info("Аутентификация пройдена");
            return ResponseEntity.ok().body(profileTokenServiceImpl.generateMapNewTokens());
        } else if (registrationServiceImpl.authenticatedFlagCheck(authLoginAndPassword)) {
            log.warn("Пользователь уже аутентифицирован");
            return ResponseEntity.ok()
                    .body(new Message("Пользователь уже аутентифицирован"));
        } else {
            log.warn("Логин или пароль неверен");
            return ResponseEntity.badRequest()
                    .body(new Message("Логин или пароль неверен"));
        }
    }
}
