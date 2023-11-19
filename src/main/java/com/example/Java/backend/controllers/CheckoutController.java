package com.example.Java.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Java.backend.dto.CartRequestDTO;

import com.example.Java.backend.services.CheckoutServiceImp;

import java.util.Map;


@RestController
@RequestMapping("/api/checkout")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class CheckoutController {
  
    @Autowired
    private CheckoutServiceImp checkoutService;

    @PostMapping("/purchase")

    public ResponseEntity<?> createCart(@RequestBody CartRequestDTO cartRequestDTO) {
      
        String orderTrackingNumber = checkoutService.processCheckout(cartRequestDTO);


        return ResponseEntity.ok(Map.of("orderTrackingNumber", orderTrackingNumber));
    }
}