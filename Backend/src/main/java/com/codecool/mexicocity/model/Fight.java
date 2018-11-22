package com.codecool.mexicocity.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Timer;

@Entity
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date timeOfFight;
    @Transient
    private Timer timer;
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
        rooster1Health = 3;
    }


    // runs all rounds creates com.codecool.mexicocity.model.Quiz
    public void fightStart(){}





    private Quiz createQuiz(int round){
        return new Quiz(round);
    }

    private boolean isRoostersAlive(){
        return false;
    }

    private void increaseExperience(){}
    private void increaseGold(){}
    private void loseHealth(){}

}
