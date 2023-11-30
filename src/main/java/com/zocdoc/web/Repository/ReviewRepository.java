package com.zocdoc.web.Repository;

import com.zocdoc.web.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByDoctorId(Long Id);
}
