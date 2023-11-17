package com.example.Java.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Java.backend.entities.Division;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    // You can define custom query methods here if needed
}
