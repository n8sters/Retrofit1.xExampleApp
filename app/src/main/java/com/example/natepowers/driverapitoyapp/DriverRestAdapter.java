package com.example.natepowers.driverapitoyapp;

import android.util.Log;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by:
 * ~~~~~~_  __     __        ____      ______
 * ~~~~~/ |/ ___ _/ /____   / __/___  /_  _____  ___ __ __
 * ~~~~/    / _ `/ __/ -_)  > _/_ _/   / / / _ \/ _ / // /
 * ~~~/_/|_/\_,_/\__/\__/  |_____/    /_/  \___/_//_\_, /
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/___/
 * ~~~~~~~~~~~~~~~~~~~  at Copia PBC   ~~~~~~~~~~~~~~~~~~~~~~
 */


public class DriverRestAdapter {

    // Username is UUID and password is token,

    protected final String TAG = getClass().getSimpleName();
    protected RestAdapter mRestAdapter;
    protected DriverApi mApi;
    static final String DRIVER_DATABASE_URL = "https://driver-gateway.gocopia.com";
    static final String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
    static final String currentToken = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiYzllNjdiMDYyOTlmYWM5MzIxO" +
            "DFlNzkyYmNjMWIzZTIxNjRkZDJmZSIsInRzIjoxNDk5ODg5OTk0fQ.OifyfFYdOxdVMSaljmvbPwR1JrhHe9" +
            "aMqA3HZRCSXyk";

    public DriverRestAdapter() {
        mRestAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(DRIVER_DATABASE_URL)
                .setErrorHandler(new DriverApiErrorHandler())
                .build();
        mApi = mRestAdapter.create(DriverApi.class);
    }

    // use the 200 status to make sure a connection is possible

    public void testDriverApi(String phone, Callback<DriverData> callback){
        Log.d(TAG, "testWeatherApi: for city:" + phone);

        mApi.getAuthRequestFromApi(phone, callback); // change this to basic ping with 200 status
    }


}
