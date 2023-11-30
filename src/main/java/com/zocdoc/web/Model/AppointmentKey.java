package com.zocdoc.web.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class AppointmentKey implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    public Long appointmentId;

    public LocalDateTime time;

}