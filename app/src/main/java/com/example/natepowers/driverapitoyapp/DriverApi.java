package com.example.natepowers.driverapitoyapp;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

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
    void getAuthRequestFromApi(
            @Query("phone") String phone,
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
