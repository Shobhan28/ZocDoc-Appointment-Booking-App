package com.zocdoc.web.Service;

import com.zocdoc.web.Entity.Appointment;
import com.zocdoc.web.Entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor addDoctor(Doctor doctor);

    public List<Doctor> getAllDoctors();

    List<Appointment> getMyAppointments(Long doctorId);
    // This method retrieves a list of appointments associated with a specific doctor.
}
