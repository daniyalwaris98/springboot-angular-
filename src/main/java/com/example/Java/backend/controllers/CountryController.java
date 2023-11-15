package com.example.Java.backend.controllers;

import com.example.Java.backend.entities.Country;
import com.example.Java.backend.services.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map; 
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<?> getAllCountries() {
        
        List<Country> countries = countryService.getAllCountries();
        
        return ResponseEntity.ok().body(Map.of("_embedded", Map.of("countries", countries)));
    }
}