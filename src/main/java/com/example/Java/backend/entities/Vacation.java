package com.example.Java.backend.entities;

import javax.persistence.*;

import com.example.Java.backend.dto.Link;

import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "vacations")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    private String description;

    @Column(name = "travel_fare_price")
    private Double travel_price;
    

    @Column(name = "image_url")
    private String image_URL;

    private Timestamp createDate;

    private Timestamp lastUpdate;

    @Transient
    private Link _links;

    @Data
    public static class Link {

    private Self self;

    @Data
    public static class Self {
        private String href;
    }
    }


    public void setSelfHref() {
        if (id != null) {
            String href = "http://localhost:8080/api/vacation/" + id;

            // Create Self link and set href
            Link.Self self = new Link.Self();
            self.setHref(href);

            // Create Link and set Self
            Link link = new Link();
            link.setSelf(self);

            // Set Link in the Vacation object
            set_links(link);
        }
    }


}