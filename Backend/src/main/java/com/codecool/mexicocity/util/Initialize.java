package com.codecool.mexicocity.util;

import com.codecool.mexicocity.model.Category;
import com.codecool.mexicocity.model.Item;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.service.ItemService;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initialize {

    RoosterService roosterService;
    UserService userService;
    ItemService itemService;

    @Autowired
    public Initialize(RoosterService roosterService, UserService userService, ItemService itemService) {
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

        Rooster rooster = new Rooster();
        rooster.addItems(helmet);
        rooster.addItems(kalas);
        rooster.addItems(vest);
        rooster.setLevel(2);
        rooster.setImage("pipi2.png");
        rooster.setExperience(50);
        rooster.setWonMatches(8);
        rooster.setLostMatches(2);
        roosterService.add(rooster);
        roosterService.updateWonMatches(rooster);
        roosterService.updateRoosterGold(rooster, 1000);
        userService.createUser("henry@mexicocity.com","henry","henry",rooster);
        Rooster rooster1 = new Rooster();
        rooster1.addItems(helmet);
        rooster1.setLevel(3);
        rooster1.setImage("pipi3.png");
        rooster1.setExperience(65);
        rooster1.setWonMatches(12);
        rooster1.setLostMatches(4);
        roosterService.add(rooster1);
        roosterService.updateWonMatches(rooster1);
        roosterService.updateRoosterGold(rooster1, 2000);
        userService.createUser("stefan@mexicocity.com","stefan","stefan",rooster1);
        Rooster rooster2 = new Rooster();
        rooster2.addItems(helmet);
        rooster2.addItems(vest);
        rooster2.setLevel(1);
        rooster2.setImage("pipi1.png");
        rooster2.setExperience(10);
        rooster2.setWonMatches(3);
        rooster2.setLostMatches(1);
        roosterService.add(rooster2);
        roosterService.updateWonMatches(rooster2);
        roosterService.updateRoosterGold(rooster2, 1300);
        userService.createUser("tocsi@mexicocity.com","tocsi","tocsi",rooster2);
        Rooster rooster3 = new Rooster();
        rooster3.addItems(helmet);
        rooster3.addItems(vest);
        rooster3.setLevel(5);
        rooster3.setImage("pipi5.png");
        rooster3.setExperience(99);
        rooster3.setWonMatches(33);
        rooster3.setLostMatches(66);
        roosterService.add(rooster3);
        roosterService.updateWonMatches(rooster3);
        roosterService.updateRoosterGold(rooster3, 4000);
        userService.createUser("mate@mexicocity.com","mate","mate",rooster3);
    }
}
