package com.example.myapp.api;

import java.net.DatagramPacket;

import retrofit2.http.GET;

public interface ApiService {
        @GET("/api/data")
        Call<DataResponse> getData();

    }