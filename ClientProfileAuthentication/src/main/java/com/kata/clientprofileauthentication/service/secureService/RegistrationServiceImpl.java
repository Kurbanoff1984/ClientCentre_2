package com.kata.clientprofileauthentication.service.secureService;

import com.kata.clientprofileauthentication.models.auth.InputFormAndAuthentication;
import com.kata.clientprofileauthentication.models.auth.dto.AuthLoginAndPassword;
import com.kata.clientprofileauthentication.models.auth.dto.RegistrationForm;
import com.kata.clientprofileauthentication.repository.secureRepository.SecureRepository;
import com.kata.clientprofileauthentication.util.LoginAndPassGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * сервис регистрации
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RegistrationServiceImpl implements RegistrationService {
    private final LoginAndPassGenerator loginAndPassGenerator;
    private final SecureRepository secureRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * сервис для генерации логина и пароля
     *
     * @param registrationForm - входня форма
     * @return - вовзрат логина и пароля пользаку
     */
    @Override
    public AuthLoginAndPassword generateLogAndPass(RegistrationForm registrationForm) {
        AuthLoginAndPassword auth = loginAndPassGenerator.generateLogAndPass(registrationForm);
        log.info("Пароль и логин сгенерированы");
        InputFormAndAuthentication inputFormAndAuthentication =
                modelMapper.map(registrationForm, InputFormAndAuthentication.class);
        inputFormAndAuthentication.setLogin(auth.getLogin());
        inputFormAndAuthentication.setPassword(
                passwordEncoder.encode(auth.getPassword()));
        inputFormAndAuthentication.setAuthenticated(false);
        secureRepository.save(inputFormAndAuthentication);
        log.info("Пользователь сохранен");
        return auth;
    }

    /**
     * сервис для валидации логина и пароля
     * @param authLoginAndPassword - вход по логину и паролю
     * @return //
     */
    @Override
    public boolean authenticationCheck(AuthLoginAndPassword authLoginAndPassword) {
        InputFormAndAuthentication inp = secureRepository.findInputFormAndAuthenticationByLogin(authLoginAndPassword.getLogin());
        if (secureRepository
                .existsInputFormAndAuthenticationByLogin(authLoginAndPassword.getLogin()) &&
                passwordEncoder
                        .matches(authLoginAndPassword.getPassword(), inp.getPassword())) {
            inp.setAuthenticated(true);
            secureRepository.flush();
            return true;
        }
        return false;
    }

    /**
     * флаг того, что пользователь уже аутентифицирован
     * @param authLoginAndPassword - входная форма логина и пароля
     * @return //
     */
    @Override
    public boolean authenticatedFlagCheck(AuthLoginAndPassword authLoginAndPassword) {
        return secureRepository.findInputFormAndAuthenticationByLogin(authLoginAndPassword.getLogin()).getAuthenticated();
    }

    /**
     * проверка на то, что входная форма уникальная (фио)
     * проверка на то, что пользователя под таким email не существует
     * @param registrationForm - входня форма регистрации
     * @return //
     */
    @Override
    public boolean inputFormToCheck(RegistrationForm registrationForm) {
        return secureRepository
                .existsInputFormAndAuthenticationByNameAndSurnameAndPatronymic(
                        registrationForm.getName(),
                        registrationForm.getSurname(),
                        registrationForm.getPatronymic()) &&
                secureRepository.existsInputFormAndAuthenticationByEmail(
                        registrationForm.getEmail());
    }
}
