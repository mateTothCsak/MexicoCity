package com.codecool.mexicocity.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Entity
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date timeOfFight;
    @Transient
    private Timer timer;
    @OneToOne
    private Rooster wonRooster;
    @OneToOne
    private Rooster lostRooster;
    private int rounds;
    private int experience;
    private int gold;
    @Transient
    private Quiz quiz;
    @OneToOne
    private Rooster rooster1;
    //@Transient
    //private Rooster rooster2;


    @Transient
    private int rooster1Health;
    @Transient
    private int rooster2Health;


    public Fight(){}
    public Fight(Rooster rooster1) {
        this.rooster1 = rooster1;
        //this.rooster2 = rooster2;
        this.timeOfFight = new Date();
        rounds = 3;
        rooster1Health = 3;
    }


    public void fightStart(Integer answer){

    }


    private Quiz createQuiz(int round){
        return new Quiz(round);
    }

    private boolean isRoostersAlive(){
        if (rooster1Health <=0) {
            return false;
        } else {
            return true;
        }
    }

    private void increaseExperience(){
    }
    private void increaseGold(){}
    private void loseHealth(){}

    public long getId() {
        return id;
    }

    public Rooster getWonRooster() {
        return wonRooster;
    }

    public void setWonRooster(Rooster wonRooster) {
        this.wonRooster = wonRooster;
    }

    public Rooster getLostRooster() {
        return lostRooster;
    }

    public void setLostRooster(Rooster lostRooster) {
        this.lostRooster = lostRooster;
    }

    public Date getTimeOfFight() {
        return timeOfFight;
    }

    public int getRounds() {
        return rounds;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public Rooster getRooster1() {
        return rooster1;
    }
}
