package com.example.Java.backend.dto;

import com.example.Java.backend.entities.Vacation;
import com.example.Java.backend.entities.Excursion;
import java.util.Set;

import lombok.Data;

@Data
public class CartItemDTO {
    private Vacation vacation;
    private Set<Excursion> excursions; 
    
}
