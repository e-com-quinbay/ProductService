package com.example.productMicroService.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Product {

    @Id
    public String id;

    public Integer merchantId;
    public String name;
    public String additionalDetail;
    public Double price;
    public Integer stock;
    public String category;
    public String image[];

}
