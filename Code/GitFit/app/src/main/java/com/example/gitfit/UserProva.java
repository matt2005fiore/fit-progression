package com.example.gitfit;

import com.google.gson.annotations.SerializedName;

public class UserProva {

    @SerializedName("username")
    String user;
    @SerializedName("password")
    String pass;

    public UserProva(String n, String p){
        this.user = n;
        this.pass = p;
    }


}
