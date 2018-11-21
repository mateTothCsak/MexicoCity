package com.codecool.mexicocity.model;

public class User {
    private int id;
    private String email;
    private String password;
    private Rooster rooster;


    // FOR REGISTRATION
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.rooster = new Rooster();
    }

    //
    // FOR LOGIN
    public User(String email, String password, Rooster rooster) {
        this.email = email;
        this.password = password;
        this.rooster = rooster;
    }




}
