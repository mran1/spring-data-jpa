package com.example.springdatajpa.service;

import com.example.springdatajpa.dao.UserRepository;
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

    @PostConstruct
    public void initDB(){
        List<User> users = new ArrayList<>();
        Product product1 = new Product(100,"computer");
        Product product2 = new Product(102,"bat");
        Product product3 = new Product(104,"draw board");
        Product product4 = new Product(101,"blazer");
        Product product5 = new Product(106,"laptop");
        Product product6 = new Product(109,"mobile");
        Product product7 = new Product(111,"camera");
        Product product8 = new Product(105,"clothes");

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product4);
        users.add(new User(1,"mustafa","software engineer",25,productList));
        List<Product> productList1 = new ArrayList<>();
        productList.add(product1);
        productList.add(product4);
        productList.add(product5);
        users.add(new User(2,"kavan","cricket player",24,productList1));
        productList.remove(product1);
        users.add(new User(3,"sam curran","chess player",23,productList));
        users.add(new User(4,"mangaldeep","civil engineer",55,productList));
        productList.add(product7);
        users.add(new User(5,"tony","Teacher",45,productList));
        productList.add(product5);
        users.add(new User(6,"alwas","Lawyer",35,productList));
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
}
