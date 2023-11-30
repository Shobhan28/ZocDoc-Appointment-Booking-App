package com.zocdoc.web.Service.Impl;

import com.zocdoc.web.Entity.AuthenticationToken;
import com.zocdoc.web.Repository.TokenRepository;
import com.zocdoc.web.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

@Autowired
private TokenRepository tokenRepo;

    @Override
    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    @Override
    public boolean authenticate(String userEmail, String token) {AuthenticationToken authToken = tokenRepo.findFirstByToken(token);
        String expectedEmail = authToken.getPatient().getPatientEmail();
        return expectedEmail.equals(userEmail);
    }
}
