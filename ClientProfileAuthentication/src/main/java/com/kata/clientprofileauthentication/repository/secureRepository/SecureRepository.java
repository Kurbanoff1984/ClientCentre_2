package com.kata.clientprofileauthentication.repository.secureRepository;

import com.kata.clientprofileauthentication.models.auth.InputFormAndAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureRepository extends JpaRepository<InputFormAndAuthentication, Long>{
    InputFormAndAuthentication findInputFormAndAuthenticationByLogin(String login);
    boolean existsInputFormAndAuthenticationByLogin(String login);
    boolean existsInputFormAndAuthenticationByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);
    boolean existsInputFormAndAuthenticationByEmail(String email);
}
