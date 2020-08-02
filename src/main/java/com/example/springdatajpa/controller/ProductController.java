package com.example.springdatajpa.controller;

import com.example.springdatajpa.model.Product;
import com.example.springdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/springjpa")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
