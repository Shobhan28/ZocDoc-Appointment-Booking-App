package com.zocdoc.web.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.zocdoc.web.Model.Specialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //This annotation marks the class as a JPA (Java Persistence API) entity,
// indicating that instances of this class will be mapped to a database table.
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class ,
        scope = Doctor.class , property = "id")
@Table(name ="doctors")
public class Doctor {

    @Id //Marks the field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String doctorName;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    private String address; // Address of the doctor's workplace

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
    // This means that one doctor can have multiple appointments.
}


  //  In summary, this Doctor entity class defines the structure and relationships of a doctor in the
//  context of your appointment booking system. It includes information such as the doctor's name, specialization,
//  and a list of appointments. The annotations provide metadata to guide the persistence framework (JPA) on
//  how to map these Java objects to database tables and handle relationships.

