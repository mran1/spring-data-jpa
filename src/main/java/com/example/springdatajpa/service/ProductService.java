package com.example.springdatajpa.service;

import com.example.springdatajpa.dao.ProductRepository;
import com.example.springdatajpa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
