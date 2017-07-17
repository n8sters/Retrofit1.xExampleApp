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


    // ----------------- BELOW METHODS ARE ALL AUTH REQUIRED ------------------ //

    // username is the UUID, password is the current access token


    // log user out and clear token
    @POST("/sessions/deauthenticate")
    Call<User> logUserOut(@Header("Authorization") String authHeader); // correct?

    // get the drivers info
    @GET("/driver")
    Call<User> getDriverInfo(@Header("Authorization") String authHeader);

    // get list of available tasks
    @GET("/tasks/available")
    Call<User> getTasks(@Header("Authorization") String authHeader);

    // upload pics and files ( signature ) related to tasks
    @POST("/tasks/upload/{type}")
    Call<User> uploadTaskFile(); // not fully implemented

    // add driver bank info to account after they pass background
    @POST("/driver/bank")
    Call<User> updateDriverBankInfo(@Header("Authorization") String authHeader);

    // update driver profile
    @POST("/driver")
    Call<User> updateDriver(@Header("Authorization") String authHeader);

    // list available tasks
    @GET("/tasks")
    Call<User> getAssignedTasks(@Header("Authorization") String authHeader);

    // get task by id
    @GET("/tasks/{taskId}")
    Call<User> getSpecificTask(@Header("Authorization") String authHeader);

    // start task
    @POST("/tasks/{taskId}/start")
    Call<User> startTask(@Header("Authorization") String authHeader);

    // arrive at task location
    @POST("/tasks/{taskId}/arrive")
    Call<User> arriveTask(@Header("Authorization") String authHeader);

    // complete task
    @POST("/tasks/{taskId}/complete")
    Call<User> completeTask(@Header("Authorization") String authHeader);

    // fail task
    @POST("/tasks/{taskId}/complete")
    Call<User> failTask(@Header("Authorization") String authHeader);


}
