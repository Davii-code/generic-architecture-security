package com.doc.genericarchitecturesecurity.service.impl;

import com.doc.genericarchitecturesecurity.dto.AuthDTO;
import com.doc.genericarchitecturesecurity.dto.CredentialDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserPasswordService {
    public static Boolean loginByPassword(AuthDTO authDTO, CredentialDTO userCredential) {
        if (!authDTO.getLogin().equals(userCredential.getLogin())) {
            return false;
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(authDTO.getPassword(), userCredential.getPassword());
    }
}


