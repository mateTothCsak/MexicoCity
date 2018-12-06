package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.ItemDao;
import com.codecool.mexicocity.model.Item;

import java.util.List;

public class ItemService {

    private ItemDao itemDao;

    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public ItemService() {
    }

    public void add(Item item) {
        this.itemDao.add(item);
    }

    public void remove(Item item) {
        this.itemDao.remove(item);
    }

    public void getItemById(Long id) {
        this.itemDao.getObjectById(id);
    }

    public List<Item> getAllItem() {
        return this.itemDao.getAllObjects("Item");
    }


}