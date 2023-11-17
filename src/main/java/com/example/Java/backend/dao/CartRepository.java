package com.example.Java.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Java.backend.entities.Cart;


public interface CartRepository extends JpaRepository<Cart, Long> {
}

