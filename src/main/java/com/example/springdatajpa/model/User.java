package com.example.springdatajpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    int id;
    String name;
    String profession;
    int age;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk",referencedColumnName = "id" )
    List<Product> products;


    public User() {
    }

    public User(int id, String name, String profession, int age, List<Product> products) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.age = age;
        this.products = products;
    }
}
