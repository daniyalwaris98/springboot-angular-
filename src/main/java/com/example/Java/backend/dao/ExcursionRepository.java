package com.example.Java.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Java.backend.entities.Excursion;

public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
    // You can define custom query methods here if needed
    List<Excursion> findByVacationId(Long vacationId);
}

