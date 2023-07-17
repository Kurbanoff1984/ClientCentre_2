package com.kata.clientprofileauthentication.util;

import com.kata.clientprofileauthentication.models.auth.dto.AuthLoginAndPassword;
import com.kata.clientprofileauthentication.models.auth.dto.RegistrationForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import ru.homyakin.iuliia.Schemas;
import ru.homyakin.iuliia.Translator;
/**
 * сервис генерации логина и пароля
 */
@Component
@Slf4j
public class LoginAndPassGenerator {
    /**
     * метод генерации логина и пароля
     * @param registrationForm - входная форма регистрации
     * @return - возвращает пару логина и пароля
     */
    public AuthLoginAndPassword generateLogAndPass(RegistrationForm registrationForm) {
        return AuthLoginAndPassword.builder()
                .login(getLogFromCompany(
                        registrationForm.getCompany(),
                        registrationForm.getName()
                        )+RandomStringUtils.randomAlphanumeric(1,3)+"@client.centre")
                .password(RandomStringUtils
                        .randomAlphanumeric(9,16))
                .build();
    }
    /**
     * генерация логина на основе имени пользователя и названия компании
     * транслита кириллицы на английский,
     * удаление пробелов, и любых других знаков кроме букв и цифр,
     * удаление всех повторов
     * слово в нижнем регистре
     * @param companyName - наименование компании
     * @param name - имя пользователя
     * @return - возвращает логин
     */
    private static String getLogFromCompany(String companyName, String name) {
        var translator = new Translator(Schemas.ICAO_DOC_9303);
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("_");
        String[] str = companyName.split(" ");
        for (String word:str) {
            word
                    .replaceAll("[^A-Za-zА-Яа-я0-9]", "")
                    .toLowerCase()
                    .chars()
                    .distinct()
                    .forEach(c -> sb.append((char) c));
        }
        return translator
                .translate(sb.toString());
    }
}
