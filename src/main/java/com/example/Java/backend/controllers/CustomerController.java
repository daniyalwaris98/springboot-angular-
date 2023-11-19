package com.example.Java.backend.controllers;


import com.example.Java.backend.dto.CustomerDTO;
import com.example.Java.backend.dto.CustomerUpdateDTO;
import com.example.Java.backend.entities.Customer;
import com.example.Java.backend.entities.Division;
import com.example.Java.backend.services.CustomerService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public ResponseEntity<?>  addCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("Received customer data: " + customerDTO);  
        Customer customer = customerService.createCustomerFromDTO(customerDTO);
        customer.setCreateDate(new Timestamp(System.currentTimeMillis()));
        customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        // customerService.createCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
   public ResponseEntity<?> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        // return ResponseEntity.ok(divisions);
        return ResponseEntity.ok().body(Map.of("_embedded", Map.of("customers", customers)));
       
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        try {
            Customer customer = customerService.getCustomerById(id);
            return ResponseEntity.ok(customer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody CustomerUpdateDTO customerUpdateDTO) {
        System.out.println("customer and id"+ customerUpdateDTO+ id);
        try {
            // Ensure the ID is set correctly on the customer object
            Customer updatedCustomer = customerService.updateCustomer(id,customerUpdateDTO);
            return ResponseEntity.ok(updatedCustomer);
        } catch (Exception e) {
            // Handle exceptions, e.g., customer not found, validation errors, etc.
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/division")
    public ResponseEntity<Division> getCustomerDivision(@PathVariable Long id) {
        try {
            Division division = customerService.getCustomerDivision(id);
            return ResponseEntity.ok(division);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
