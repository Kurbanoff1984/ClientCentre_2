package com.kata.clientprofileauthentication.service.secureService;

import com.kata.clientprofileauthentication.models.auth.dto.AuthLoginAndPassword;
import com.kata.clientprofileauthentication.models.auth.dto.RegistrationForm;

public interface RegistrationService {
    AuthLoginAndPassword generateLogAndPass(RegistrationForm registrationForm);
    boolean authenticationCheck(AuthLoginAndPassword authLoginAndPassword);
    boolean authenticatedFlagCheck(AuthLoginAndPassword authLoginAndPassword);
    boolean inputFormToCheck(RegistrationForm registrationForm);
}
