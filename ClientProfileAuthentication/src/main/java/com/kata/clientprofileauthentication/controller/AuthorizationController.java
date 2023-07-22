package com.kata.clientprofileauthentication.controller;

import com.kata.clientprofileauthentication.models.auth.dto.Message;
import com.kata.clientprofileauthentication.models.tokens.BearerOrJwtBearerToken;
import com.kata.clientprofileauthentication.models.tokens.ProfileToken;
import com.kata.clientprofileauthentication.service.tokenService.tokenServiceImpl.BlackProfileTokenServiceImpl;
import com.kata.clientprofileauthentication.service.tokenService.tokenServiceImpl.ProfileTokenManagerImpl;
import com.kata.clientprofileauthentication.service.tokenService.tokenServiceImpl.ProfileTokenServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * контроллер для работы с токенами
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
@Tag(name = "Контроллер", description = "Все методы для работы c токенами")
public class AuthorizationController {
    private final ProfileTokenServiceImpl profileTokenServiceImpl;
    private final BlackProfileTokenServiceImpl blackProfileTokenServiceImpl;
    private final ProfileTokenManagerImpl profileTokenManagerImpl;

    /**
     * тестовый метод
     * @return - возвращает в заголовке пару новых токенов Bearer и JwtBearer
     * токены сохраняются в бд
     */
    @Operation(summary = "Создание новых токенов (Тестовый метод)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ProfileToken.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/newTokens")
    public ResponseEntity<?> newTestTokens() {
        return ResponseEntity.ok()
                .body(profileTokenServiceImpl.generateMapNewTokens());
    }
    /**
     * метод проверяет на правильность запроса
     * метод проверяет на синтаксис токена
     * метод проверяет на наличии токена в черном списке
     * метод проверяет токена на валидацию (подделка подписи и тп)
     * Под капотом старый токены сохраняются в blackList
     * @param token - принимает на вход 1 из дух токенов
     * @return возвращает обновленный JwtBearer или Bearer токен
     */
    @Operation(summary = "Эндпоинт для ClientProfileFacade",
            description = "Возврат обновленных токенов")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BearerOrJwtBearerToken.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Неправильный запрос")) }),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping("/authenticationFromFacadeValidation")
    public ResponseEntity<?> ClientProfileAuthenticationFromFacade(
            @RequestBody BearerOrJwtBearerToken token) {
        String bearerOrJwtBearerToken = token.getBearerOrJwtBearerToken();
        if (StringUtils.isBlank(bearerOrJwtBearerToken)) {
            log.warn("Incorrect request");
            return ResponseEntity.badRequest().body(new Message("Incorrect request"));
        }
        if (profileTokenManagerImpl.getTokenType(bearerOrJwtBearerToken).equals("Incorrect")) {
            log.warn("Incorrect token");
            return ResponseEntity.badRequest().body(new Message("Incorrect token"));
        }
        if (profileTokenServiceImpl.serviceValidateBearerOrJwtBearerToken(bearerOrJwtBearerToken)) {
            log.warn("Invalid token");
            return ResponseEntity.badRequest()
                    .body(new Message("Invalid token"));
        }
        if (blackProfileTokenServiceImpl.findBlackTokens(bearerOrJwtBearerToken)) {
            log.error("Токен в черном списке");
            return ResponseEntity.badRequest()
                    .body(new Message("Токен в черном списке"));
        }
        return ResponseEntity.ok().body(new Message(profileTokenManagerImpl.updateToken(bearerOrJwtBearerToken)));
    }
}


