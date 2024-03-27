package com.doorDash.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String discription;
    private Long price;
    @ManyToOne
    private Category category;
    @Column(length = 1000)
    @ElementCollection
    private List<String> images;
    private boolean available;
    @ManyToOne
    private Restaurant restaurant;
    private boolean isVegetarian;
    private boolean seasonal;
    @ManyToMany
    private List<IngredientsItem> ingredientsItems = new ArrayList<>();
    private Date creationDate;

}
