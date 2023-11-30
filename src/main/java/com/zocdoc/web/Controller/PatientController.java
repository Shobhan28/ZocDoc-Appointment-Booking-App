package com.zocdoc.web.Controller;

import com.zocdoc.web.Entity.Doctor;
import com.zocdoc.web.Service.AuthenticationService;
import com.zocdoc.web.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {


    @Autowired
    private PatientService patientService;

    @Autowired
    private AuthenticationService authService;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam String userEmail, @RequestParam String token) {

        HttpStatus status;
        List<Doctor> allDoctors = null;

        //authenticate
        if (authService.authenticate(userEmail, token)) {

            allDoctors = patientService.getAllDoctors();
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Doctor>>(allDoctors, status);


    }
}
