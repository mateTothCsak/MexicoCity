package com.codecool.mexicocity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
public class ItemConnector {

    Rooster rooster;
    Item item;


    public ItemConnector(Rooster rooster, Item item) {
        this.rooster = rooster;
        this.item = item;
    }

    public Rooster getRooster() {
        return rooster;
    }

    public void setRooster(Rooster rooster) {
        this.rooster = rooster;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
