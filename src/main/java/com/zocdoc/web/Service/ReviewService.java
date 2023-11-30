package com.zocdoc.web.Service;

import com.zocdoc.web.Entity.Review;

import java.util.List;

public interface ReviewService {

    public Review createReview(Review review);

    public List<Review> getReviewByDoctorId(long doctorId);
}
