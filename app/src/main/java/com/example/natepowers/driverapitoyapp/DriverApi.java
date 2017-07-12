package com.example.natepowers.driverapitoyapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


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


    @POST("/sessions/authenticate/request")
    Call<User> createAccount(@Body User user);

    @POST("/sessions/authenticate/request")
    void getAuthRequestFromApi(
            Callback<DriverData> callback);

    @POST("/sessions/authenticate")
    void logDriverIn(
            @Query("phone") String phone,
            Callback<DriverData> callback);


    // is this right?
    interface getDriverInfo {
        @Headers("Username:UUID")
        @GET("/driver")
        List<DriverData> getTasks();
    }

    /*   Example auth request from SO

    @GET("/secret_things")
    SecretThing.List getSecretThings(@Header("Authorization") String token)
    */

}
