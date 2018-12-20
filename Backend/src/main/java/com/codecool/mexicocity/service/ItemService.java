package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.ItemRepository;
import com.codecool.mexicocity.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemService() {
    }

    public void add(Item item) {
        this.itemRepository.save(item);
    }

    public void remove(Item item) {
        this.itemRepository.delete(item);
    }

    public Item getItemById(Long id) throws Exception {
        Optional<Item> foundItem = this.itemRepository.findById(id);
        if (foundItem.isPresent()){
            return foundItem.get();
        }  else {
            throw new Exception("Item with id not found");
        }

    }

    public List<Item> getAllItem() {
        return this.itemRepository.findAll();
    }


}