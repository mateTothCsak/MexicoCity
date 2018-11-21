package com.codecool.mexicocity.model;

import java.util.ArrayList;
import java.util.List;

public class FreeShop {
    List<Item> items = new ArrayList<Item>();

    public void addShopItems(List<Item> addItemsToFreeShop) {
        items = addItemsToFreeShop;
    }
}
