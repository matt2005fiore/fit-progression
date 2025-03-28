package com.example.myapp.api;

import com.example.gitfit.UserProva;

import java.net.DatagramPacket;
import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
        @POST("/login")
        Call<ResponseBody> login(@Body UserProva user);





    }