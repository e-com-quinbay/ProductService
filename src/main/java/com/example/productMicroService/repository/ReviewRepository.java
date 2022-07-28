package com.example.productMicroService.repository;

import com.example.productMicroService.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review,String> {

    List<Review> findByUserId(String id);

}
