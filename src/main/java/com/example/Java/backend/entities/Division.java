package com.example.Java.backend.entities;

import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "divisions")
@Data
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

@Column(name ="create_date" )
    private Timestamp createDate;

@Column(name ="last_update" )

    private Timestamp lastUpdate;

    @Column(name ="country_id" )

    private Long country_id;
}
