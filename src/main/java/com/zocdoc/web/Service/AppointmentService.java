package com.zocdoc.web.Service;

import com.zocdoc.web.Entity.Appointment;
import com.zocdoc.web.Model.AppointmentKey;

public interface AppointmentService {

    public void bookAppointment(Appointment appointment);

    public void cancelAppointment(AppointmentKey key);

}
