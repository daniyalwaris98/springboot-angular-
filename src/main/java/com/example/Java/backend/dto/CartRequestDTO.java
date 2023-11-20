package com.example.Java.backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class CartRequestDTO {
 private CartDTO cart;
 private List<CartItemDTO> cartItems;
 private CustomerDTO customer;
 private int nextIndex;
}
