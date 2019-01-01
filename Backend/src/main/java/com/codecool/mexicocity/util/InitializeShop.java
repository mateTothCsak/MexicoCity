package com.codecool.mexicocity.util;

import com.codecool.mexicocity.model.Category;
import com.codecool.mexicocity.model.Item;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.service.ItemService;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;
import com.codecool.mexicocity.util.MyEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitializeShop {

    RoosterService roosterService;
    UserService userService;
    ItemService itemService;

    @Autowired
    public InitializeShop(RoosterService roosterService, UserService userService, ItemService itemService) {
        this.roosterService = roosterService;
        this.userService = userService;
        this.itemService = itemService;
    }

    @PostConstruct
    public void initDatabase() throws Exception {
        //Items:
        //PIMP

        itemService.add(new Item("Pimp Stick", "Nice pimp stick", 1000, "resources/img/pimpStick.jpg", Category.WEAPON));
        itemService.add(new Item("Pimp Hat", "Beautiful pimp hat", 2500, "resources/img/pimpHat.jpg", Category.HEADGEAR));
        itemService.add(new Item("Pimp Fur", "Nice pimp warm coat", 1000, "resources/img/pimpFur.jpg", Category.ARMOR));
        itemService.add(new Item("Seal-Ring", "Hot pimp ring", 1000, "resources/img/seal-ring.jpg", Category.RINGS));

        //Soldier
        Item helmet = new Item("Soldier helmet", "It is useful sometimes", 100, "resources/img/soldierHelmet.jpg", Category.HEADGEAR);
        Item kalas = new Item("Soldier Kalasnikov", "Bumm Bumm", 1000, "resources/img/kalasnikov.jpg", Category.WEAPON);
        Item vest = new Item("Soldier Vest", "Prrrotection 100", 450, "resources/img/vest.jpg", Category.ARMOR);
        itemService.add(helmet);
        itemService.add(kalas);
        itemService.add(vest);

        Rooster rooster = roosterService.createRooster();
        rooster.addItems(helmet);
        rooster.addItems(kalas);
        rooster.addItems(vest);
        roosterService.updateRoosterGold(rooster, 1000);
        userService.createUser("henry","henry",rooster);
        Rooster rooster1 = roosterService.createRooster();
        userService.createUser("stefan","stefan",rooster1);
        Rooster rooster2 = roosterService.createRooster();
        userService.createUser("tocsi","tocsi",rooster2);
        Rooster rooster3 = roosterService.createRooster();
        userService.createUser("mate","mate",rooster3);
    }
}
