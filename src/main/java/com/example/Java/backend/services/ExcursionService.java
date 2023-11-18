package com.example.Java.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Java.backend.dao.ExcursionRepository;
import com.example.Java.backend.entities.Excursion;

import java.util.List;

@Service
public class ExcursionService {
    @Autowired
    private ExcursionRepository excursionRepository;

    public Excursion addExcursion(Excursion excursion) {
        // You can include validation or business logic here
        return excursionRepository.save(excursion);
    }

    public Excursion updateExcursion(Long id, Excursion excursion) {
        // Check if excursion exists, throw exception if not
        Excursion existingExcursion = excursionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Excursion not found"));
        // Update the fields of the existing excursion
        // For example: existingExcursion.setName(excursion.getName());
        // Save the updated excursion
        return excursionRepository.save(existingExcursion);
    }

    public List<Excursion> getAllExcursions() {
        return excursionRepository.findAll();
    }

    public Excursion getExcursionById(Long id) {
        return excursionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Excursion not found"));
    }

    // Method to delete an excursion
    public void deleteExcursion(Long id) {
        if (!excursionRepository.existsById(id)) {
            throw new RuntimeException("Excursion not found");
        }
        excursionRepository.deleteById(id);
    }

    
    public List<Excursion> getExcursionsByVacationId(Long vacationId) {
        return excursionRepository.findByVacationId(vacationId);
    }

}
