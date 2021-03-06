package com.codecool.mexicocity.model;

import com.codecool.mexicocity.util.Globals;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "player")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String name;

    //@JsonManagedReference is for Jackson to BETTER handle jackson
    //the back part of reference – it will be omitted from serialization
    @OneToOne
    @JsonManagedReference
    private Rooster myRooster;

    private String salt;


    public User(String email, String name, String password, Rooster rooster) {
        this.email = email;
        this.salt = generateSalt();
        this.password = generateHash(password, salt);
        this.myRooster = rooster;
        this.name = name;
    }


    public User() {}


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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String generateHash(String passwordToHash, String   salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }


    public static String generateSalt() {
        byte[] salt = new byte[16];
        Globals.getRANDOM().nextBytes(salt);
        return salt.toString();
    }
}
