package com.example.springdatajpa.controller;

import com.example.springdatajpa.dto.OrderReport;
import com.example.springdatajpa.model.User;
import com.example.springdatajpa.service.UserService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/springjpa")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/findByProfession/{profession}")
    public List<User> findByProfession(@PathVariable String profession){
        return userService.findByProfession(profession);
    }

    @GetMapping("/countByAge/{age}")
    public String countByAge(@PathVariable int age){
        return "number of users with age "+age+userService.countByAge(age);
    }

    @DeleteMapping("/deleteByName/{name}")
    public List<User> deleteByName(@PathVariable String name){
        return userService.deleteByName(name);
    }

    @GetMapping("/findByProfessionAndAge/{profession}/{age}")
    public List<User> findByProfessionAndAge(@PathVariable String profession, @PathVariable int age){
        return userService.findByProfessionAndAge(profession, age);
    }

    @GetMapping("/findByName/{name}")
    public List<User> findByName(@PathVariable String name){
        return userService.findByName(name);
    }

    @GetMapping("/getUsersBySort/{field}")
    public List<User> getUsersBySort(@PathVariable String field){
        return userService.getUsersBySort(field);
    }

    @GetMapping("/getUsersByCustomQuery")
    public List<User> getUsersBySort(){
        return userService.getUsersCustomQuery();
    }

    @GetMapping("/getAllOrderReports/{name}")
    public List<OrderReport> getAllOrderReport(@PathVariable String name){
        return userService.getAllOrderReports(name);
    }
}
