package com.example.Java.backend.services;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Java.backend.entities.Cart;

import com.example.Java.backend.dao.CartRepository;


import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;


    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

   

}
