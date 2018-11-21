package com.codecool.mexicocity.model;

import java.util.ArrayList;
import java.util.List;

public class Rooster {
    private int id;
    private boolean online = true;
    private int experience;
    private int level;
    private int gold;
    private List<Item> items = new ArrayList<Item>();
    private User user;
    private int wonMatches;
    private int lostMatches;
    private int winRatio;
    private String image;


    private MyServer myServer;


    // Constructor used when new user registers
    public Rooster() {
        this.experience = 0;
        this.level = 1;
        this.gold = 0;
        this.wonMatches = 0;
        this.lostMatches = 0;
        this.image = "resources/img/pipi1.jpg";
    }

    // Details extracted from DB, constructor used when user already has an account
    public Rooster(int experience, int level, int gold, List<Item> items, int wonMatches, int lostMatches, String image) {
        this.experience = experience;
        this.level = level;
        this.gold = gold;
        this.items = items;
        this.wonMatches = wonMatches;
        this.lostMatches = lostMatches;
        this.image = image;
    }


    // triggered when player wants to start a fight
    public void requestToStartFighting(){
        //TODO
    }

    // com.codecool.mexicocity.model.User sends her/his solution for the quiz
    public int sendSolution(){
        return 0;
    }

    //Calls addItems() and Pay() methods
    public void buyItem(Item item){
        if(isEnoughGold(item)){
            addItems(item);
        }
    }

    // Adds item to items
    private void addItems(Item item){
        //TODO
    }


    // Pays for the item
    // Checks whether we have enough money if so deducts from the gold if
    private boolean isEnoughGold(Item item){
        //TODO
        return false;
    }


    // Calculates winRatio
    private void calculateWinRatio(){
        //TODO
    }


    // METHODS FOR FIGHTS
    public void initializeFight(){
        myServer = new MyServer();
        myServer.createFight(this);
    }




    public void fightWon(int goldToAdd, int experienceToAdd){
        increaseGold(goldToAdd);
        increaseExperience(experienceToAdd);
        //TODO
    }


    public void fighLost(int experienceToAdd){
        //TODO
        increaseExperience(experienceToAdd);
    }




    private void increaseGold(int goldToAdd){
        //TODO
    }

    private void increaseExperience(int experienceToAdd){
        //TODO
    }


    // GETTERS FOR FIELDS
    // returns items
    public List<Item> getItems() {
        return items;
    }

    //
    //

}
