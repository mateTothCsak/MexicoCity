package com.codecool.mexicocity.model;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;

    @OneToOne
    private Rooster myRooster;


    // FOR REGISTRATION
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.myRooster = new Rooster();
    }

    //
    // FOR LOGIN
    public User(String email, String password, Rooster rooster) {
        this.email = email;
        this.password = password;
        this.myRooster = rooster;
    }


    public User() {
    }
}
