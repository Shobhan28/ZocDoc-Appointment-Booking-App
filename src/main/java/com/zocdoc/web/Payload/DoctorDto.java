package com.zocdoc.web.Payload;

import com.zocdoc.web.Entity.Doctor;
import com.zocdoc.web.Entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    private Doctor doctor;
    private List<Review> reviews;
    private double ratingPercentage;
    private int yearsOfExperience; // Years of experience of the doctor
    private String qualification; // Qualifications of the doctor

}

// DTOs(Data Transfer Objects) are commonly used to transfer data the service layer and
// the view or API layer of an application.