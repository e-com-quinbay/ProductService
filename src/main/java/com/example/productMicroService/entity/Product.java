package com.example.productMicroService.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Getter
@Setter
@Document
public class Product {

    @Id
    public String id;

    public Integer merchantId;
    public String name;

    public HashMap<String, String> additionalDetails = new HashMap<>();

    public Double price;
    public Integer stock;
    public String category;
    public String image[];

}
