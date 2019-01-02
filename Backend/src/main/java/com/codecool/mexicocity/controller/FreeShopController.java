package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Item;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.service.ItemService;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.util.JsonHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.RollbackException;
import javax.servlet.http.HttpServlet;
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
    public List<Item> loadShop() throws JsonProcessingException {
        List<Item> items = itemService.getAllItem();
        return items;
    }

    @PostMapping("/shop")
    public String sendPurchaseItem(@RequestBody ObjectNode json ) throws Exception {

        // seperate class
        String itemJson = json.get("item").toString();
        String roosterJson = json.get("rooster").toString();
        try {
            // rearrange to service class
            Item item = (Item) JsonHandler.getInstance().objectFromJson(itemJson, Item.class);
            Rooster rooster = (Rooster) JsonHandler.getInstance().objectFromJson(roosterJson, Rooster.class);
            roosterService.buyItem(rooster, item);
            // RoosterId/ItemId might be enough
        } catch (RollbackException ex){
            return "[SHOP] Wrong Item Json or Rooster Json";
        }
        return "[SHOP] " + itemJson + " bought by " + roosterJson;
    }

}
