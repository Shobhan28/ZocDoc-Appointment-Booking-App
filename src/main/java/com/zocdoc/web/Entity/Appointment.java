package com.zocdoc.web.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.zocdoc.web.Model.AppointmentKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = Appointment.class,property = "id")
@Table(name = "appointments")
public class Appointment {

    @EmbeddedId
    private AppointmentKey appointmentId;

    @ManyToOne
    private Patient patient;


    // Appointement default time will be 60 mins from appoaintment start time.


    private LocalDateTime appointmentDateAndTime;


    @ManyToOne
    private Doctor doctor;

    @OneToOne
    @JsonIgnore
    private Review review;

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        Appointment other = (Appointment) obj;

        return Objects.equals(appointmentId, other.appointmentId);

    }



}