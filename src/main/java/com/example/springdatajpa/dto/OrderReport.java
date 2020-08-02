package com.example.springdatajpa.dto;

import lombok.Data;

@Data
public class OrderReport {

    String name;
    String productName;

    public OrderReport() {

    }

    public OrderReport(String name, String productName) {
        this.name = name;
        this.productName = productName;
    }
}
