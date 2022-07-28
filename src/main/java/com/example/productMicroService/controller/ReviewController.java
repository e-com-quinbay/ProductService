package com.example.productMicroService.controller;

import com.example.productMicroService.entity.Review;
import com.example.productMicroService.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/review")
public class ReviewController
{
    @Autowired
    ReviewService reviewServices;

    @GetMapping(value = "/{id}")
    public List<Review> getReview (@PathVariable(value = "id") String id)
    {
        return reviewServices.getReviews(id);
    }

    @PostMapping("/addreview")
    public Review addReview (@RequestBody Review review)
    {
        return reviewServices.addReview(review);
    }
}
