package com.example.Java.backend.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "customer_first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "customer_last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "address", length = 255)
    private String address;

    // @Column(name = "city", length = 100)
    // private String city;

    @Column(name = "postal_code", length = 20)
    private String postal_code;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "create_date", nullable = true)
    private Timestamp createDate;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    // Getters and setters
}