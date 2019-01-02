package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.RoosterRepository;
import com.codecool.mexicocity.model.Item;
import com.codecool.mexicocity.model.Rooster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoosterService {

    private RoosterRepository roosterRepository;

    private ItemService itemService;

    public RoosterService(){ }

    @Autowired
    public RoosterService(RoosterRepository roosterRepository, ItemService itemService) {
        this.roosterRepository = roosterRepository;
        this.itemService = itemService;
    }

    public void add(Rooster rooster) {
        this.roosterRepository.save(rooster);
    }

    public void remove(Rooster rooster) {
        this.roosterRepository.delete(rooster);
    }

    public Rooster getRoosterById(Long id) throws Exception {
        Optional<Rooster> foundRooster = this.roosterRepository.findById(id);
        if (foundRooster.isPresent()){
            return foundRooster.get();
        } else {
            throw new Exception("Rooster with id not found");
        }
    }

    public List<Rooster> getAllRooster() {
        return this.roosterRepository.findAll();
    }

    public Rooster createRooster(){
        Rooster rooster = new Rooster();
        add(rooster);
        return rooster;
    }

    public List<Rooster> getTopRoosters() {
        return this.roosterRepository.findTop10ByOrderByWonMatchesDesc();
    }


    public void updateRoosterGold(Rooster rooster, int gold) throws Exception {
        Rooster foundRooster = this.getRoosterById(rooster.getId());
        foundRooster.setGold(foundRooster.getGold() + gold);
        this.roosterRepository.save(foundRooster);
    }

    public void updateRoosterExperience(Rooster rooster, int experience) throws Exception {
        Rooster foundRooster = this.getRoosterById(rooster.getId());
        foundRooster.setExperience(foundRooster.getExperience() + experience);
        this.roosterRepository.save(foundRooster);
    }

    public void updateRoosterLevel(Rooster rooster, int level) throws Exception {
        Rooster foundRooster = this.getRoosterById(rooster.getId());
        foundRooster.setGold(foundRooster.getLevel() + level);
        this.roosterRepository.save(foundRooster);
    }

    public void checkLevelUp(Rooster rooster) throws Exception {
        Rooster foundRooster = this.getRoosterById(rooster.getId());
        String image;
            if (foundRooster.getExperience() >= 100) {
                image = "resources/img/pipi"+foundRooster.getLevel()+1 + ".jpg";
                foundRooster.setLevel(foundRooster.getLevel() + 1);
                foundRooster.setExperience(0);
                foundRooster.setImage(image);
                this.roosterRepository.save(foundRooster);
            }
    }

    public void updateWonMatches(Rooster rooster) throws Exception {
        Rooster foundRooster = this.getRoosterById(rooster.getId());
        foundRooster.setWonMatches(foundRooster.getWonMatches() + 1);

        float totalMatches = foundRooster.getLostMatches() + foundRooster.getWonMatches();
        float ratio = foundRooster.getWonMatches()/totalMatches;
        foundRooster.setWinRatio((int) (ratio * 100));

        this.roosterRepository.save(foundRooster);
    }

    public void updateLostMatches(Rooster rooster) throws Exception {
        Rooster foundRooster = this.getRoosterById(rooster.getId());
        foundRooster.setLostMatches(foundRooster.getLostMatches() + 1);

        float totalMatches = foundRooster.getLostMatches() + foundRooster.getWonMatches();
        float ratio = foundRooster.getWonMatches()/totalMatches;
        foundRooster.setWinRatio((int) (ratio * 100));

        this.roosterRepository.save(foundRooster);
    }


    public void buyItem(Rooster rooster, Item item) throws Exception {
        Rooster foundRooster = this.getRoosterById(rooster.getId());
        Item foundItem = this.itemService.getItemById(item.getId());

        if(isEnoughGold(foundRooster, foundItem) && !alreadyHaveItem(foundRooster, foundItem)) {
            foundRooster.addItems(item);
            foundRooster.setGold(foundRooster.getGold()-foundItem.getPrice());
            this.roosterRepository.save(foundRooster);

        }
    }

    public boolean isEnoughGold(Rooster rooster, Item item) throws Exception {
        Rooster foundRooster = this.getRoosterById(rooster.getId());
        if(foundRooster.getGold() >= item.getPrice()){
            System.out.println("Item successfully bought");
            return true;
        }
        //throw new ArithmeticException("Not enough gold");
        System.out.println("Not enough gold");
        return false;
    }

    public boolean alreadyHaveItem(Rooster rooster, Item item) throws Exception { ;
        if (haveItemInList(rooster.getRoosterItems(), item)){
            System.out.println("Already own item");
            return true;
        }
        System.out.println("Item successfully bought");
        return false;
    }

    private boolean haveItemInList(List<Item> items, Item item){
        for (Item inventoryItem : items){
            if (inventoryItem.getId() == item.getId()){
                return true;
            }
        }
        return false;
    }

}
