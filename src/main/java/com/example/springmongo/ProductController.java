package com.example.springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public void addProduct(@RequestBody final List<Product> products){
        productRepository.saveAll(products);
    }

    @GetMapping("/products")
    public List<Product> findProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{productId}")
    public Product findProducts(@PathVariable final String productId){
        return productRepository.findById(productId).orElseGet(Product::new);
    }
}
