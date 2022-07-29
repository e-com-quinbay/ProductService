package com.example.productMicroService.controller;

import com.example.productMicroService.entity.Product;
import com.example.productMicroService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "/")
@CrossOrigin(value = "*")
public class ProductController
{
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> home() {
        return productService.findAllProducts();
    }

    @GetMapping(value = "/category/{category}")
    public List<Product> getByCategory(@PathVariable("category") String category) {
        return productService.findByCategory(category);
    }

    @GetMapping(value = "/{productId}")
    public Optional<Product> detail(@PathVariable("id") String id) {
        return productService.findProductById(id);
    }

    @GetMapping(value = "/findByMerchant/{id}")
    public List<Product> getByMerchant(@PathVariable("id") int id)
    {
        return productService.findByMerchant(id);
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

}
