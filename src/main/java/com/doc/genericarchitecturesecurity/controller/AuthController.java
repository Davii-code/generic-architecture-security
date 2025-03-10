package com.doc.genericarchitecturesecurity.controller;

import com.doc.genericarchitecturesecurity.config.Constants;
import com.doc.genericarchitecturesecurity.dto.AuthDTO;
import com.doc.genericarchitecturesecurity.dto.CredentialDTO;
import com.doc.genericarchitecturesecurity.service.impl.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version}/auth")
public class AuthController extends AbstractController{

    @Autowired
    private AuthService authService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthDTO authDTO) {
        CredentialDTO credential = authService.login(authDTO);
        return ResponseEntity.ok(credential);
    }

    @GetMapping(path = "/refresh")
    public ResponseEntity<?> refresh(@RequestParam String refreshToken) {
        CredentialDTO credential = authService.refresh(refreshToken);
        return ResponseEntity.ok(credential);
    }

    @GetMapping(path = "/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String authHeader = request.getHeader(Constants.HEADER_AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith(Constants.HEADER_AUTHORIZATION_BEARER)) {
            authService.logout(authHeader);
        }
        return ResponseEntity.ok().build();
    }

}
