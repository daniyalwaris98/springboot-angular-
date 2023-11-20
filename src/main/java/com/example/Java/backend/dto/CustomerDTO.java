package com.example.Java.backend.dto;

import lombok.Data;
import java.util.Optional;

@Data
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String postal_code;
    private String phone;
    private Optional<String> country = Optional.empty(); // Optional field, assuming URL
    private Optional<String> division = Optional.empty();
    // private Optional<Long> id = Optional.empty();
    private Long id;
    

    // Getters and setters
}
