package com.example.natepowers.driverapitoyapp;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;



public interface DriverApi {



    // requests an access code, which expires in 5-10 min
    @POST("/sessions/authenticate/request")
    Call<User> requestAccessCode(@Body User user); // DONE

    // request access token to log in
    @POST("/sessions/authenticate")
    Call<User> requestToken(@Body User user); // DONE


    // ----------------- BELOW METHODS ARE ALL AUTH REQUIRED ------------------ //

    // username is the UUID, password is the current access token


    // log user out and clear token
    @POST("/sessions/deauthenticate")
    Call<User> logUserOut(@Header("Authorization") String authHeader); // DONE

    // upload picture of the drivers' license, registration etc...
    @Multipart
    @POST("/tasks/upload/jpg")
    Call<User> uploadDriverPicture(@Header("Authorization") String authHeader,
                                    @Part String description,
                                    @Part MultipartBody.Part photo);

    // get the drivers info
    @GET("/driver")
    Call<User> getDriverInfo(@Header("Authorization") String authHeader); //DONE

    // get list of available tasks
    @GET("/tasks/available")
    Call<List<Task>> getAvailableTasks(@Header("Authorization") String authHeader); //DONE


    // upload pics and files ( signature ) related to tasks
    @Multipart
    @POST("/tasks/upload/{type}")
    Call<User> uploadTaskFile(@Header("Authorization") String authHeader,
                              @Part MultipartBody.Part photo);

    // add driver bank info to account after they pass background
    @POST("/driver/bank")
    Call<User> updateDriverBankInfo(@Header("Authorization") String authHeader);

    // update driver profile
    @POST("/driver")
    Call<User> updateDriver(@Header("Authorization") String authHeader,
                            @Field("info") String body);

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
