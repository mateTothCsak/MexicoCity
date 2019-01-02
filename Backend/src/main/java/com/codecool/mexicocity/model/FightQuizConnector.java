package com.codecool.mexicocity.model;

import java.util.List;

public class FightQuizConnector {

    private Fight fight;
    private List quizes;

    public FightQuizConnector(Fight fight, List quizes) {
        this.fight = fight;
        this.quizes = quizes;
    }

    public Fight getFight() {
        return fight;
    }

    public void setFight(Fight fight) {
        this.fight = fight;
    }

    public List getQuizes() {
        return quizes;
    }

    public void setQuizes(List quizes) {
        this.quizes = quizes;
    }
}
