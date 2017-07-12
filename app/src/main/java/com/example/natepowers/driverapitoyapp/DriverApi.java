package com.example.natepowers.driverapitoyapp;

import retrofit.Callback;
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
    void getAuthRequestFromApi (
            @Query("phone") String phone,
            Callback<DriverData> callback);

    @POST("/sessions/authenticate")
    void logDriverIn(
            @Query("phone") String phone,
            Callback<DriverData> callback);
}
