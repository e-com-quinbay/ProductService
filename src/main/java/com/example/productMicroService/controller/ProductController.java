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

    @GetMapping(value = "/product/{productId}")
    public Product detail(@PathVariable("productId") String id) {
        return productService.findProductById(id);
    }

    @GetMapping(value = "/findByMerchant/{id}")
    public List<Product> getByMerchant(@PathVariable("id") int id)
    {
        return productService.findByMerchant(id);
    }

    @GetMapping(value = "availableStock/{productId}")
    public int getAvailableStock(@PathVariable("productId") String productId)
    {
        return productService.findAvailableProduct(productId);
    }

    @GetMapping(value = "decreaseStock/{productId}/{quantity}")
    public int decreaseStock(@PathVariable("productId") String productId, @PathVariable int quantity)
    {
        return productService.decreaseStock(productId, quantity);
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PostMapping(value = "/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("delete/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

}
