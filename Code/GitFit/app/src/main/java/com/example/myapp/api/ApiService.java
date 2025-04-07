package com.example.myapp.api;

import com.example.gitfit.User;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {


    @POST("/user")
    Call<User> createUser(@Body User user);

    @POST("/login")
    Call<ResponseBody> login(@Body User user);
}
