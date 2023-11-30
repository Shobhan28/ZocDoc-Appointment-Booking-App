package com.zocdoc.web.Service.Impl;

import com.zocdoc.web.Entity.Appointment;
import com.zocdoc.web.Repository.AppointmentRepository;
import com.zocdoc.web.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Override
    public void bookAppointment(Appointment appointment) {
        Optional<Appointment> myAppointment = appointmentRepo.findById(appointment.getAppointmentId());
        if (myAppointment.isPresent()) {
            appointmentRepo.save(appointment);
        } else {
            throw new IllegalStateException("Appointment with id already present");
        }
    }
}
