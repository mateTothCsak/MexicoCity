package com.codecool.mexicocity.util;

import com.codecool.mexicocity.model.Category;
import com.codecool.mexicocity.model.Item;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.service.ItemService;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;
import com.codecool.mexicocity.util.MyEntityManagerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class InitializeShop {
    RoosterService roosterService;
    UserService userService;
    ItemService itemService;


    public InitializeShop(RoosterService roosterService, UserService userService, ItemService itemService) {
        this.roosterService = roosterService;
        this.userService = userService;
        this.itemService = itemService;
    }


    public void initDatabase() {
        //Items:
        //PIMP

        itemService.add(new Item("Pimp Stick", "Nice pimp stick", 1000, "image/pimpStick.jpg", Category.WEAPON));
        itemService.add(new Item("Pimp Hat", "Beautiful pimp hat", 2500, "image/pimpHat.jpg", Category.HEADGEAR));
        itemService.add(new Item("Pimp Fur", "Nice pimp warm coat", 1000, "image/pimpFur.jpg", Category.ARMOR));
        itemService.add(new Item("Seal-Ring", "Hot pimp ring", 1000, "image/seal-ring.jpg", Category.RINGS));

        //Soldier

        itemService.add(new Item("Soldier helmet", "It is useful sometimes", 100, "image/soldierHelmet.jpg", Category.HEADGEAR));
        itemService.add(new Item("Soldier Kalasnikov", "Bumm Bumm", 1000, "image/kalasnikov.jpg", Category.WEAPON));
        itemService.add(new Item("Soldier Vest", "Prrrotection 100", 450, "image/vest.jpg", Category.ARMOR));

        Rooster rooster = roosterService.createRooster();
        userService.createUser("henry","henry",rooster);
        Rooster rooster1 = roosterService.createRooster();
        userService.createUser("stefan","stefan",rooster1);
        Rooster rooster2 = roosterService.createRooster();
        userService.createUser("tocsi","tocsi",rooster2);
        Rooster rooster3 = roosterService.createRooster();
        userService.createUser("mate","mate",rooster3);
    }
}
