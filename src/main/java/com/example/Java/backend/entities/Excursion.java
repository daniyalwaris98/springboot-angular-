package com.example.Java.backend.entities;

import javax.persistence.*;
import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "excursions")
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    private String excursion_title;

    private Double excursion_price;

    @Column(name = "image_url")
    private String image_URL;

    private Timestamp create_date;

    private Timestamp last_update;

    @ManyToOne
    @JoinColumn(name = "vacationId", nullable = false)
    private Vacation vacation;

   @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems = new HashSet<>();
  


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
            String href = "http://localhost:8080/api/excursions/" + id;

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