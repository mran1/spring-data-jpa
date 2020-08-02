package com.example.springdatajpa.service;

import com.example.springdatajpa.dao.ProductRepository;
import com.example.springdatajpa.dao.UserRepository;
import com.example.springdatajpa.dto.OrderReport;
import com.example.springdatajpa.model.Product;
import com.example.springdatajpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    public void initDB(){
        List<User> users = new ArrayList<>();

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(109,"head phones"));
        productList.add(new Product(110,"ear phones"));
        users.add(new User(1,"mustafa","software engineer",25,productList));

        List<Product> productList2 = new ArrayList<>();
        productList2.add(new Product(101,"blazer"));
        productList2.add(new Product(100,"computer"));
        users.add(new User(2,"kavan","cricket player",24,productList2));
        List<Product> productList3 = new ArrayList<>();
        productList3.add(new Product(102,"washing machine"));
        productList3.add(new Product(103,"draw board"));
        users.add(new User(3,"sam curran","chess player",23,productList3));
        List<Product> productList4 = new ArrayList<>();
        productList4.add(new Product(104,"Refrigirator"));
        productList4.add(new Product(105,"laptop"));
        users.add(new User(4,"mangaldeep","civil engineer",55,productList4));
        List<Product> productList5 = new ArrayList<>();
        productList5.add(new Product(106,"bat"));
        productList5.add(new Product(107,"Mobile"));
        users.add(new User(5,"tony","Teacher",45,productList5));
        List<Product> productList6 = new ArrayList<>();
        productList6.add(new Product(108,"Television"));
        users.add(new User(6,"alwas","Lawyer",35,productList6));
        userRepository.saveAll(users);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> findByProfession(String profession){
        return userRepository.findByProfession(profession);
    }

    public int countByAge(int age){
        return userRepository.countByAge(age);
    }

    public List<User> deleteByName(String name){
        return userRepository.deleteByName(name);
    }


    public List<User> findByProfessionAndAge(String profession, int age){
        return userRepository.findByProfessionAndAge(profession, age);
    }

    public List<User> findByName(String name){
        return userRepository.findByNameIgnoreCase(name);
    }

    public List<User> getUsersBySort(String field){
        return userRepository.findAll(Sort.by(field));
    }

    public List<User> getUsersCustomQuery(){
        return userRepository.getUsersCustomQuery();
    }

    public List<OrderReport> getAllOrderReports(String name){
        return userRepository.getAllOrderReports(name);
    }
}
