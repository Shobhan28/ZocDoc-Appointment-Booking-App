package com.zocdoc.web.Service;

import com.zocdoc.web.Entity.Doctor;
import com.zocdoc.web.Model.AppointmentKey;

import java.util.List;

public interface PatientService {

    public List<Doctor> getAllDoctors();

    public void cancelAppointment(AppointmentKey key);

}
