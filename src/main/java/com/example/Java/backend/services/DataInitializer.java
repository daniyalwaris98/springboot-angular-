package com.example.Java.backend.services;

import com.example.Java.backend.dao.CustomerRepository;
import com.example.Java.backend.entities.Customer;
import com.example.Java.backend.entities.Division;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class DataInitializer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DivisionService divisionService;

    @PostConstruct
    @Transactional
    public void initData() {
        // Check if customers already exist
        if (customerRepository.count() == 0) {
            // Create and add customers
            addSampleCustomers();
        }
    }

    private void addSampleCustomers() {
        Division division = divisionService.getDivisionById(3L).orElse(null);
        
        // Example: Adding five customers
        customerRepository.saveAll(List.of(
            new Customer(1L, "John", "Doe", "123 Street", "12345", "123-456-7890", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), division),
            new Customer(2L, "Jane", "Smith", "456 Avenue", "67890", "098-765-4321", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), division),
            new Customer(3L, "Bob", "Johnson", "789 Road", "54321", "987-654-3210", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),division),
            new Customer(4L, "Alice", "Williams", "987 Lane", "13579", "456-789-0123", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),division),
            new Customer(5L, "thomas", "quear", "937 Lane", "13279", "456-789-0023", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),division)

            // Add more customers here
        ));
    }
}
