package com.example.gitfit;

public class User {

    private int id;
    private String name;
    private String surname;
    private float weight;
    private float height;
    private boolean gender;
    private String password;
    private String eMail;  // Correct field for email

    // Default constructor (required for Retrofit)
    public User() {}

    // Constructor for login (use eMail, not username)
    public User(String eMail, String password) {
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMail() {  // Correct method name
        return eMail;
    }

    public void seteMail(String eMail) {  // Correct method name
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
