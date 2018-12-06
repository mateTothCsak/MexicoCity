package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.RoosterDao;
import com.codecool.mexicocity.model.Item;
import com.codecool.mexicocity.model.Rooster;

import java.util.List;

public class RoosterService {

    private RoosterDao roosterDao;

    public RoosterService(){ }


    public RoosterService(RoosterDao roosterDao) {
        this.roosterDao = roosterDao;
    }

    public void add(Rooster rooster) {
        this.roosterDao.add(rooster);
    }

    public void remove(Rooster rooster) {
        this.roosterDao.remove(rooster);
    }

    public Rooster getRoosterById(Long id) {
        return (Rooster) this.roosterDao.getObjectById(id);
    }

    public List<Rooster> getAllRooster() {
        return this.roosterDao.getAllObjects("Rooster");
    }

    public Rooster createRooster(){
        Rooster rooster = new Rooster();
        add(rooster);
        return rooster;
    }

    public List<Rooster> getTopRoosters() {
        return this.roosterDao.getTopRoosters();
    }

    public void updateRoosterGold(Rooster rooster, int gold) {
        this.roosterDao.increaseRoosterGold(rooster,gold);
    }

    public void updateRoosterExperience(Rooster rooster, int experience) {
        this.roosterDao.updateExperience(rooster,experience);
    }

    public void updateRoosterLevel(Rooster rooster, int level) {
        this.roosterDao.updateLevel(rooster,level);
    }

    public void checkLevelUp(Rooster rooster) {
        if (rooster.getExperience() >= 100) {
            updateRoosterLevel(rooster,rooster.getLevel() + 1);
            roosterDao.setExperienceToZero(rooster);
            roosterDao.updateImage(rooster);
        }
    }

    public void updateWonMatches(Rooster rooster) {
        this.roosterDao.updateRoosterWonMatches(rooster);
        this.roosterDao.updateRoosterWinRatio(rooster);
    }

    public void updateLostMatches(Rooster rooster) {
        this.roosterDao.updateRoosterLostMatches(rooster);
        this.roosterDao.updateRoosterWinRatio(rooster);
    }


    public void buyItem(Rooster rooster, Item item){
        if(isEnoughGold(rooster, item) && !alreadyHaveItem(rooster, item)) {
            this.roosterDao.updateItems(rooster, item);
            this.roosterDao.decreaseRoosterGold(rooster, item.getPrice());
        }
    }

    private boolean isEnoughGold(Rooster rooster, Item item){
        if(rooster.getGold() >= item.getPrice()){
            System.out.println("Item bought");
            return true;
        }
        System.out.println("Not enough gold");
        return false;
    }

    private boolean alreadyHaveItem(Rooster rooster, Item item){
        if (haveItemInList(rooster.getRoosterItems(), item)){
            System.out.println("Already own item");
            return true;
        }
        System.out.println("Item got");
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
