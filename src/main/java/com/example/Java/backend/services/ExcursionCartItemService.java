// package com.example.Java.backend.services;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.Java.backend.dao.ExcursionCartItemRepository;
// import com.example.Java.backend.entities.ExcursionCartItem;

// @Service
// public class ExcursionCartItemService {
//     @Autowired
//     private ExcursionCartItemRepository excursionCartItemRepository;

//        public List<ExcursionCartItem> getAllExcursionCartItems() {
//         return excursionCartItemRepository.findAll();
//     }

//     public ExcursionCartItem getExcursionCartItemById(Long id) {
//         return excursionCartItemRepository.findById(id).orElse(null);
//     }

//     public ExcursionCartItem createExcursionCartItem(ExcursionCartItem excursionCartItem) {
//         return excursionCartItemRepository.save(excursionCartItem);
//     }

//     public void deleteExcursionCartItem(Long id) {
//         excursionCartItemRepository.deleteById(id);
//     }
    
// }
