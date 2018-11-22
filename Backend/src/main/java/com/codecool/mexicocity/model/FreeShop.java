package com.codecool.mexicocity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
public class FreeShop {

    private int id;

    private List<Item> shopItems = new ArrayList<Item>();

    public void addShopItems(List<Item> addItemsToFreeShop) {
        shopItems = addItemsToFreeShop;
    }

    public FreeShop() {
    }
}
