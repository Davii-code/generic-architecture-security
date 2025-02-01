package com.doc.genericarchitecturesecurity.security.impl;


import com.doc.genericarchitecturesecurity.config.Constants;
import com.doc.genericarchitecturesecurity.dto.CredentialDTO;
import com.doc.genericarchitecturesecurity.service.IUserProviderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class LogoutService implements LogoutHandler {

    @Autowired
    private IUserProviderService userProviderService;

    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {

        String authHeader = request.getHeader(Constants.HEADER_AUTHORIZATION);
        if (authHeader == null ||!authHeader.startsWith(Constants.HEADER_AUTHORIZATION_BEARER)) {
            return;
        }
        userProviderService.recordLog((CredentialDTO) CredentialProvider.newInstance().getCurrentInstance(), Constants.ACTION_LOGOUT);
        SecurityContextHolder.clearContext();
    }
}
