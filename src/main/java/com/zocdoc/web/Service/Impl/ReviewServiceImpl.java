package com.zocdoc.web.Service.Impl;

import com.zocdoc.web.Entity.Doctor;
import com.zocdoc.web.Entity.Patient;
import com.zocdoc.web.Entity.Review;
import com.zocdoc.web.Repository.DoctorRepository;
import com.zocdoc.web.Repository.PatientRepository;
import com.zocdoc.web.Repository.ReviewRepository;
import com.zocdoc.web.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    @Override
    public Review createReview(Review review) {
        Doctor doctor = doctorRepo.findById(review.getDoctor().getId()).get();

        Patient patient = patientRepo.findById(review.getPatient().getPatientId()).get();

        Review saveReview = null;
        if (doctor != null || patient != null) {
            saveReview = reviewRepo.save(review);
        }
        return saveReview;
    }

    @Override
    public List<Review> getReviewByDoctorId(long doctorId) {
        List<Review> review = reviewRepo.findByDoctorId(doctorId);

        return review;
    }
}



