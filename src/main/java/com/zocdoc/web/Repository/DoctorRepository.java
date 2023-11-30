package com.zocdoc.web.Repository;

import com.zocdoc.web.Entity.Appointment;
import com.zocdoc.web.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

 //   List<Appointment> findByDoctorId(Long doctorId);

}

// By extending JpaRepository, DoctorRepository inherits a set of methods for common database operations
// such as save, findById, findAll, delete, etc.
// The generic parameters <Doctor, Long> specify that this repository works with entities of type Doctor and
// uses Long as the type of the primary key.