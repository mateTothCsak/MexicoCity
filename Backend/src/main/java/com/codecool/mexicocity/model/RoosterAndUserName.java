package com.codecool.mexicocity.model;

import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;

public class RoosterAndUserName {

    private Rooster rooster;
    private String name;

    public RoosterAndUserName(Rooster rooster, String name) {
        this.rooster = rooster;
        this.name = name;
    }

    public Rooster getRooster() {
        return rooster;
    }

    public void setRooster(Rooster rooster) {
        this.rooster = rooster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
