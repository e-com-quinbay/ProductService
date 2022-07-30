package com.example.productMicroService.services;


import com.example.productMicroService.entity.Product;
import com.example.productMicroService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product findProductById (String id) {

        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent())
            return productOptional.get();

        return null;
    }

    public List<Product> findByMerchant(int id){
        return productRepository.findByMerchantId(id);
    }

    public int findAvailableProduct(String id){
        Product product = findProductById(id);

        if (product!=null){
            return product.getStock();
        }
        else
            return -1;
    }

    public int decreaseStock(String id, int quantity){

        Product product = findProductById(id);

        if (product!=null){
            int stock = product.getStock();
            if(stock > quantity)
            {
                stock-=quantity;
                product.setStock(stock);
                productRepository.save(product);
                return stock;
            }
            else
            {
                return -1;
            }
        }
        else
            return -1;
    }

    public Product createProduct(Product product) {

        Product newProduct =  productRepository.save(product);
        pushToElasticSearch(newProduct);
        return newProduct;
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public void pushToElasticSearch(Product product){
        String url = "http://10.20.3.120:8081/saveOne";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, product, Product.class);
    }

}
