package com.example.Java.backend.controllers;


import com.example.Java.backend.dto.ExcursionResponseDTO;
import com.example.Java.backend.entities.Excursion;
import com.example.Java.backend.services.ExcursionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/excursions")
public class ExcursionController {

    @Autowired
    private ExcursionService excursionService;

    // Get all excursions
    @GetMapping
    public ResponseEntity<ExcursionResponseDTO> getAllExcursions() {
        List<Excursion> excursions = excursionService.getAllExcursions();

        for (Excursion excursion : excursions) {
            excursion.setSelfHref();
        }

        ExcursionResponseDTO responseDto = new ExcursionResponseDTO();
        responseDto.setExcursions(excursions);
        
        return ResponseEntity.ok(responseDto);
    }

    // // Get a single excursion by ID
    // @GetMapping("/{id}")
    // public ResponseEntity<Excursion> getExcursionById(@PathVariable Long id) {
    //     Excursion excursion = excursionService.getExcursionById(id);
    //     return ResponseEntity.ok(excursion);
    // }

    // // Delete an excursion
    // @DeleteMapping("/{id}")
    // public ResponseEntity<?> deleteExcursion(@PathVariable Long id) {
    //     excursionService.deleteExcursion(id);
    //     return ResponseEntity.ok("Excursion deleted successfully");
    // }
}
