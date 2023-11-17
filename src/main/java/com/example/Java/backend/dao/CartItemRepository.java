package com.example.Java.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Java.backend.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long > {

    
} 
