package com.example.productMicroService.repository;

import com.example.productMicroService.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findByCategory(String category);
    List<Product> findByMerchantId(int id);
}
