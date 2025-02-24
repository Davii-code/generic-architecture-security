package com.doc.genericarchitecturesecurity.security;

import java.util.List;

public interface Credential {
    String getLogin();
    List<String> getRoles();
    String getAccessToken();
}
