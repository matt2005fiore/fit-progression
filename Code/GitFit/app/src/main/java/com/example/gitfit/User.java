package com.example.gitfit;

import com.google.gson.annotations.SerializedName;

public class User {

        private int id;
        private String firstname;
        private String surname;
        private float weight;
        private float height;
        private boolean gender;

    @SerializedName("password")
        private String password;
    @SerializedName("email")
        private String eMail;

    // Default constructor (required for Retrofit)
    public User() {}

    // Constructor for login (use eMail, not username)
    public User(String eMail, String password) {
        this.eMail = eMail;
        this.password = password;
    }

    // New constructor for FormActivity
    public User(String name, String surname, float weight, float height, String eMail, String password) {
        this.firstname = name;
        this.surname = surname;
        this.weight = weight;
        this.height = height;
        this.eMail = eMail;
        this.password = password;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return firstname;
    }

    public void setName(String name) {
        this.firstname = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
