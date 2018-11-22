package com.codecool.mexicocity.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private int price;
    private String image;

    @ManyToOne()
    private Rooster rooster;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Item() {}

    public Item(String name, String description, int price, String image, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }

}
