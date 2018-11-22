package com.codecool.mexicocity.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String password;

    //@JsonManagedReference is for Jackson to BETTER handle jackson
    @OneToOne
    @JsonManagedReference
    private Rooster myRooster;


    public User(String email, String password, Rooster rooster) {
        this.email = email;
        this.password = password;
        this.myRooster = rooster;
    }


    public User() {
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Rooster getMyRooster() {
        return myRooster;
    }
}
