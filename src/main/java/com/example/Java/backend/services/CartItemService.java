package com.example.Java.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Java.backend.dao.CartItemRepository;
import com.example.Java.backend.entities.CartItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CartItemService {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private CartItemRepository cartItemRepository;

    
    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
    
}
