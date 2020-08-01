package com.example.springdatajpa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    @Id
    int id;
    String name;

    public Product() {

    }
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
