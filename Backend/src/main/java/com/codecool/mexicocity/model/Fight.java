package com.codecool.mexicocity.model;

import java.util.Timer;

public class Fight {
    private int id;
    private Timer timer;
    private int rounds;
    private int experience;
    private int gold;
    private Quiz quiz;
    private Rooster rooster1;
    private Rooster rooster2;

    private int rooster1Health;
    private int rooster2Health;


    public Fight(Rooster rooster1, Rooster rooster2) {
        this.rooster1 = rooster1;
        this.rooster2 = rooster2;
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
