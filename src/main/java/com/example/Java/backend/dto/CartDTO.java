package com.example.Java.backend.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartDTO {
    private BigDecimal package_price;
    private Number party_size;
    private String status;
    private CustomerDTO customer;
    private Long id;
    
}
