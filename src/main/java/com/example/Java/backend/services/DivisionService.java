package com.example.Java.backend.services;

import com.example.Java.backend.dao.DivisionRepository;
import com.example.Java.backend.entities.Division;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;
    
    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    public Optional<Division> getDivisionById(Long id) {
        return divisionRepository.findById(id);
    }
}
