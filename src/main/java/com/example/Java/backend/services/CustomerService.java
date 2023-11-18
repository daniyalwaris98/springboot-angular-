package com.example.Java.backend.services;

import com.example.Java.backend.entities.Customer;
import com.example.Java.backend.entities.Division;
import com.example.Java.backend.dao.CustomerRepository;
import com.example.Java.backend.dao.DivisionRepository;
import com.example.Java.backend.dto.CustomerDTO;
import com.example.Java.backend.dto.CustomerUpdateDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DivisionRepository divisionRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }
    public Division getCustomerDivision(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
            System.out.println("asd");
        return customer.getDivision();
    }

    public Customer updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO) {
       
        Customer existingCustomer = customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found"));

// Update the customer's details
updateCustomerDetails(existingCustomer, customerUpdateDTO);

// Save the updated customer
return customerRepository.save(existingCustomer);
    }

    private void updateCustomerDetails(Customer customer, CustomerUpdateDTO dto) {
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setAddress(dto.getAddress());
        customer.setPhone(dto.getPhone());
        customer.setPostal_code(dto.getPostal_code());
    }


    public Customer createCustomerFromDTO(CustomerDTO customerDTO) {
    Customer customer = new Customer();
    customer.setFirstName(customerDTO.getFirstName());
    customer.setLastName(customerDTO.getLastName());
    customer.setAddress(customerDTO.getAddress());
    customer.setPostal_code(customerDTO.getPostal_code());
    customer.setPhone(customerDTO.getPhone());

    // Long divisionId = extractIdFromUrl(customerDTO.getDivision());
    Optional<String> divisionUrl = customerDTO.getDivision();
    Long divisionId = divisionUrl.map(this::extractIdFromUrl).orElse(null);
    System.out.println(" data: " + divisionId);  

    // Country country = countryRepository.findById(countryId).orElseThrow();
    Division division = divisionRepository.findById(divisionId).orElseThrow();
    

    customer.setDivision(division);

    return customerRepository.save(customer);
}
private Long extractIdFromUrl(String url) {
    String[] parts = url.split("/");
    try {
        return Long.parseLong(parts[parts.length - 1]);
    } catch (NumberFormatException e) {
        // Handle the case where the URL does not end with a number
        throw new IllegalArgumentException("Invalid URL: " + url);
    }
}
}
