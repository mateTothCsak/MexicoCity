package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Item;
import com.codecool.mexicocity.model.ItemConnector;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.service.ItemService;
import com.codecool.mexicocity.service.RoosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FreeShopController{

    private ItemService itemService;
    private RoosterService roosterService;

    @Autowired
    public FreeShopController(ItemService itemService, RoosterService roosterService) {
        this.itemService = itemService;
        this.roosterService = roosterService;
    }


    @GetMapping("/shop")
    public List<Item> loadShop() {
        return itemService.getAllItem();
    }

    @PostMapping("/shop")
    public String sendPurchaseItem(@RequestBody ItemConnector itemConnector ) throws Exception {
        Item item = itemConnector.getItem();
        Rooster rooster = itemConnector.getRooster();
        if (roosterService.alreadyHaveItem(rooster, item)){
            return "Rooster already owns item";
        } else if (!roosterService.isEnoughGold(rooster, item)){
            return "Rooster doesn't have enough gold";
        }
        roosterService.buyItem(rooster, item);
        return "[SHOP] " + item.getName() + " bought by " + "RoosterId: " + rooster.getId();
    }

}
