package com.zocdoc.web.Service.Impl;

import com.zocdoc.web.Entity.Appointment;
import com.zocdoc.web.Entity.Doctor;
import com.zocdoc.web.Repository.AppointmentRepository;
import com.zocdoc.web.Repository.DoctorRepository;
import com.zocdoc.web.Service.DoctorService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {


    private AppointmentRepository appointmentRepo;
    private final DoctorRepository doctorRepo;

    public DoctorServiceImpl(AppointmentRepository appointmentRepo,
                             DoctorRepository doctorRepo) {
        this.appointmentRepo = appointmentRepo;
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        // You can add additional validation logic here if needed.
        return doctorRepo.save(doctor);

    }
        @Override
        public List<Appointment> getMyAppointments(Long doctorId) {
            Doctor myDoc = doctorRepo.findById(doctorId)
                    .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + doctorId));

            return myDoc.getAppointments();
        }
    }


    // implementing methods to add a doctor and retrieve appointments for a given doctor ID. Dependency injection is used
// for repository access, and the code includes proper exception handling for cases where a doctor is not found.
// The service layer encapsulates business logic and interacts with repositories for database operations.
