package com.example.Java.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Java.backend.entities.Vacation;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
    // You can define custom query methods here if needed
}
