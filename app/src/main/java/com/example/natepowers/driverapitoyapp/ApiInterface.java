package com.example.natepowers.driverapitoyapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("/tasks/upload/jpg")
    Call<User> uploadImage(@Header("Authorization") String authHeader,
                                   @Field("title") String title,
                                   @Field("image") String image);


}
