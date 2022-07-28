package com.example.productMicroService.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Review {

    @Id
    public String id;

    public String productId;
    public String review;
    public Integer rating;
    public Integer userId;

}
