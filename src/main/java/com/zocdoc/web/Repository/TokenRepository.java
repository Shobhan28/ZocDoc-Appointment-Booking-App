package com.zocdoc.web.Repository;

import com.zocdoc.web.Entity.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Long> {

    //    AuthenticationToken findByPatient(Patient patient);
    AuthenticationToken findFirstByToken(String token);
}

