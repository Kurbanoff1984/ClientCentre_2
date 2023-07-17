package com.kata.clientprofilefacade1.controller;

import com.kata.clientprofilefacade1.models.BearerOrJwtBearerToken;
import com.kata.clientprofilefacade1.models.ProfileToken;
import com.kata.clientprofilefacade1.service.serviceImpl.BlackProfileTokenServiceImpl;
import com.kata.clientprofilefacade1.service.serviceImpl.ProfileTokenManagerImpl;
import com.kata.clientprofilefacade1.service.serviceImpl.ProfileTokenServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class AuthorizationController {
    private final ProfileTokenServiceImpl profileTokenServiceImpl;
    private final BlackProfileTokenServiceImpl blackProfileTokenServiceImpl;
    private final ProfileTokenManagerImpl profileTokenManagerImpl;

    /**
     * тестовый метод
     * @return возвращает в заголовке пару новых токенов Bearer и JwtBearer
     * токены сохраняются в бд
     */

    @GetMapping("/newTokens")
    public ResponseEntity<ProfileToken> newTestTokens() {
        ProfileToken newTokens = profileTokenServiceImpl
                .generateNewAllTokenServiceImpl();
        return ResponseEntity.ok()
                .header("BearerToken", newTokens.getBearerToken())
                .header("JwtBearerToken", newTokens.getJwtBearerToken())
                .build();
    }
    /**
     * тестовый метод
     * @param bearerOrJwtBearerToken
     * @return возвращает status 200, если токен есть в бд
     */
    @PostMapping("/authenticationFromFacade")
    public ResponseEntity<String> ClientProfileAuthenticationFromFacade(
            @RequestBody BearerOrJwtBearerToken bearerOrJwtBearerToken) {
        if (bearerOrJwtBearerToken.getBearerOrJwtBearerToken().startsWith("Bearer ") &&
                profileTokenServiceImpl.findBearerTokenBool(
                bearerOrJwtBearerToken.getBearerOrJwtBearerToken())) {
            return ResponseEntity.ok().body("Bearer токен найден");
            } else if (bearerOrJwtBearerToken.getBearerOrJwtBearerToken().startsWith("JwtBearer ") &&
                profileTokenServiceImpl.findJwtBearerTokenBool(
                        bearerOrJwtBearerToken.getBearerOrJwtBearerToken())) {
            return ResponseEntity.ok().body("JwtBearer токен найден");
        }
        return ResponseEntity.badRequest().body("Token Invalid");
    }
    /**
     * метод вовзращает новый токен в зависимости от того, какой токен на него пришел
     * Под капотом старый токены сохраняются в blackList
     * @param bearerOrJwtBearerToken
     * @return возвращает новый JwtBearer или Bearer токен
     */
    @PostMapping("/authenticationFromFacadeValidationUpdate")
    public ResponseEntity<String> ClientProfileAuthenticationFromFacadeValidationUpdate(
            @RequestBody BearerOrJwtBearerToken bearerOrJwtBearerToken) {
        ProfileToken updateTokens = profileTokenManagerImpl.updateProfileToken(bearerOrJwtBearerToken);
        if (bearerOrJwtBearerToken.getBearerOrJwtBearerToken().startsWith("Bearer ")) {
            return ResponseEntity.ok()
                    .header("New BearerToken", updateTokens.getBearerToken()).build();
        } else if (bearerOrJwtBearerToken.getBearerOrJwtBearerToken().startsWith("JwtBearer ")) {
            return ResponseEntity.ok()
                    .header("New JwtBearerToken", updateTokens.getJwtBearerToken()).build();
        } else return ResponseEntity.badRequest().body("Invalid request");

    }
    /**
     * основной метод, проверяет есть ли токены в blacklist,
     * есть ли токены в бд
     * валидны ли токены (проверка правильности их написания, даты экспирации, подделки подписи и тп)
     * @param bearerOrJwtBearerToken
     * @return возвращает status 200, если токен есть в бд и он валидный
     */

    @PostMapping("/authenticationFromFacadeValidationMain")
    public ResponseEntity<String> ClientProfileAuthenticationFromFacadeValidationMain
            (@RequestBody BearerOrJwtBearerToken bearerOrJwtBearerToken) {
        String tokenType = profileTokenManagerImpl.getTokenType(bearerOrJwtBearerToken.getBearerOrJwtBearerToken());
        if (StringUtils.isBlank(tokenType)) {
            return ResponseEntity.badRequest().body("Incorrect token");
        }
        if (blackProfileTokenServiceImpl.findBlackTokens(bearerOrJwtBearerToken)) {
            return ResponseEntity.ok().body("BlackList tokens");
        }
        if (profileTokenServiceImpl.findTokenBool(tokenType, bearerOrJwtBearerToken.getBearerOrJwtBearerToken())) {
            if (profileTokenServiceImpl.serviceValidateBearerOrJwtBearerToken(bearerOrJwtBearerToken.getBearerOrJwtBearerToken())) {
                return ResponseEntity.ok().body(tokenType + " токен найден, token valid");
            } else {
                return ResponseEntity.ok().body(tokenType + " токен найден, token Invalid");
            }
        } return ResponseEntity.badRequest().body("Token Invalid");
    }
}


