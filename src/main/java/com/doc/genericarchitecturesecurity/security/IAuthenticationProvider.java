package com.doc.genericarchitecturesecurity.security;

public interface IAuthenticationProvider {
    Credential getAuthentication(final String token);
}
