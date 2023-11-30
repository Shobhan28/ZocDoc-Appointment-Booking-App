package com.zocdoc.web.Service.Impl;

import com.zocdoc.web.Entity.Doctor;
import com.zocdoc.web.Model.AppointmentKey;
import com.zocdoc.web.Service.AppointmentService;
import com.zocdoc.web.Service.DoctorService;
import com.zocdoc.web.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @Override
    public void cancelAppointment(AppointmentKey key) {
        appointmentService.cancelAppointment(key);
    }
}
