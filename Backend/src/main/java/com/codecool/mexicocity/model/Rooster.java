package com.codecool.mexicocity.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Rooster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean online = true;
    private int experience;
    private int level;
    private int gold;
    @OneToOne(mappedBy = "wonRooster")
    private Fight wonFight;
    @OneToOne(mappedBy = "lostRooster")
    private Fight lostFight;

    @ManyToMany(fetch = FetchType.EAGER)
    //@JsonBackReference
    private List<Item> roosterItems = new ArrayList<>();

    //@JsonManagedReference is for Jackson to BETTER handle jackson
    //the forward part of reference – the one that gets serialized normally
    @OneToOne(mappedBy = "myRooster",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private User user;

    private int wonMatches;
    private int lostMatches;
    private int winRatio;
    private String image;

    @OneToOne(mappedBy = "rooster1")
    private Fight fight;

    @Transient
    private MyServer myServer;


    // Constructor used when new user registers
    public Rooster() {
        this.experience = 0;
        this.level = 1;
        this.gold = 0;
        this.wonMatches = 0;
        this.lostMatches = 0;
        this.image = "pipi1.png";
    }

    // Details extracted from DB, constructor used when user already has an account
    public Rooster(int experience, int level, int gold, List<Item> roosterItems, int wonMatches, int lostMatches, String image) {
        this.experience = experience;
        this.level = level;
        this.gold = gold;
        this.roosterItems = roosterItems;
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

    // Adds item to shopItems
    public void addItems(Item item){
        this.roosterItems.add((item));
    }


    // Pays for the item
    // Checks whether we have enough money if so deducts from the gold if
    private boolean isEnoughGold(Item item){
        //TODO
        return false;
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
    // returns shopItems
    public List<Item> getRoosterItems() {
        return roosterItems;
    }

    public long getId() {
        return id;
    }

    public boolean isOnline() {
        return online;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public User getUser() {
        return user;
    }

    public int getWonMatches() {
        return wonMatches;
    }

    public int getLostMatches() {
        return lostMatches;
    }

    public int getWinRatio() {
        return winRatio;
    }

    public String getImage() {
        return image;
    }

    public Fight getFight() {
        return fight;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setWonMatches(int wonMatches) {
        this.wonMatches = wonMatches;
    }

    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }

    public void setWinRatio(int winRatio) {
        this.winRatio = winRatio;
    }

    public void setImage(String image) {
        this.image = image;
    }
    //
    //
    public Fight getWonFight() {
        return wonFight;
    }

    public void setWonFight(Fight wonFight) {
        this.wonFight = wonFight;
    }

    public Fight getLostFight() {
        return lostFight;
    }

    public void setLostFight(Fight lostFight) {
        this.lostFight = lostFight;
    }

    @Override
    public String toString() {
        return "Rooster{" +
                "id=" + id +
                ", online=" + online +
                ", experience=" + experience +
                ", level=" + level +
                ", gold=" + gold +
                ", roosterItems=" + roosterItems +
                ", user=" + user +
                ", wonMatches=" + wonMatches +
                ", lostMatches=" + lostMatches +
                ", winRatio=" + winRatio +
                ", image='" + image + '\'' +
                '}';
    }
}
