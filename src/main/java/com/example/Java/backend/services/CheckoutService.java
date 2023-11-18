package com.example.Java.backend.services;

import com.example.Java.backend.dto.CartRequestDTO;

public interface CheckoutService {

    String processCheckout(CartRequestDTO cartRequestDTO);

    // You can declare other methods that you expect the checkout service to implement
}