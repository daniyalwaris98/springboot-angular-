package com.example.Java.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Java.backend.entities.Country;


public interface CountryRepository extends JpaRepository<Country, Long> {
    // You can define custom query methods here if needed
}
