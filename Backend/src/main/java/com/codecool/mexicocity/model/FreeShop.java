package com.codecool.mexicocity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class FreeShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "freeShop")
    private List<Item> shopItems = new ArrayList<Item>();

    public void addShopItems(List<Item> addItemsToFreeShop) {
        shopItems = addItemsToFreeShop;
    }

    public FreeShop() {
    }
}
