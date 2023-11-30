package com.zocdoc.web.Service;

import com.zocdoc.web.Entity.AuthenticationToken;

public interface AuthenticationService {

    public void saveToken(AuthenticationToken token);

    public boolean authenticate(String userEmail, String token);
}
