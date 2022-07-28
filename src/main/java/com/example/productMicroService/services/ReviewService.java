package com.example.productMicroService.services;


import com.example.productMicroService.entity.Review;
import com.example.productMicroService.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService
{

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getReviews(String id) {
        return reviewRepository.findByUserId(id);
    }

    public Review addReview (Review review) {
        return reviewRepository.save(review);
    }

}
