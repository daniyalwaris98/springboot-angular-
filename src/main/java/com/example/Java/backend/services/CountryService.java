package com.example.Java.backend.services;

import com.example.Java.backend.dao.CountryRepository;
import com.example.Java.backend.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

      public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
