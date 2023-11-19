package com.example.Java.backend.controllers;

import com.example.Java.backend.entities.Division;
import com.example.Java.backend.services.DivisionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")

@RequestMapping("/api")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @GetMapping("/divisions")
    public ResponseEntity<?> getAllDivisions() {
        List<Division> divisions = divisionService.getAllDivisions();
        // return ResponseEntity.ok(divisions);
        return ResponseEntity.ok().body(Map.of("_embedded", Map.of("divisions", divisions)));
       
    }
}
