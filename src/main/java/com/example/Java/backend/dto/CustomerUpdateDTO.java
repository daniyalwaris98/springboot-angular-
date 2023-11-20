package com.example.Java.backend.dto;

import lombok.Data;

@Data
public class CustomerUpdateDTO {
    private String address;
    private String division; // Assuming division is represented by a URL or ID
    private String firstName;
    private String lastName;
    private String phone;
    private String postal_code;
}
