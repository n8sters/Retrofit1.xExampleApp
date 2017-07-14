package com.example.natepowers.driverapitoyapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


/**
 * Created by:
 * ~~~~~~_  __     __        ____      ______
 * ~~~~~/ |/ ___ _/ /____   / __/___  /_  _____  ___ __ __
 * ~~~~/    / _ `/ __/ -_)  > _/_ _/   / / / _ \/ _ / // /
 * ~~~/_/|_/\_,_/\__/\__/  |_____/    /_/  \___/_//_\_, /
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/___/
 * ~~~~~~~~~~~~~~~~~~~  at Copia PBC   ~~~~~~~~~~~~~~~~~~~~~~
 */

public interface DriverApi {


    // requests an access code, which expires in 5-10 min
    @POST("/sessions/authenticate/request")
    Call<User> requestAccessCode(@Body User user);

    // request access token to log in
    @POST("/sessions/authenticate")
    Call<User> requestToken(@Body User user);


    // get the drivers info  ( AUTH REQUIRED )
    @GET("/driver")
    Call<User> getDriverInfo(@Header("Authorization") String authToken);




}
