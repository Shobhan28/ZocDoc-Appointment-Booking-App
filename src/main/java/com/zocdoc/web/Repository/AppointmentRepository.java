package com.zocdoc.web.Repository;

import com.zocdoc.web.Entity.Appointment;
import com.zocdoc.web.Model.AppointmentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentKey> {


}
