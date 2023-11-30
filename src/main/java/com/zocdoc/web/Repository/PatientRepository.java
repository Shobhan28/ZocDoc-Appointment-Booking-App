package com.zocdoc.web.Repository;

import com.zocdoc.web.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findFirstByPatientEmail(String userEmail);
}
