package com.example.natepowers.driverapitoyapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by natepowers on 8/14/17.
 */

class ApiSingleton {

    private static final String TAG = "ApiSingleton";
    public static Task resultTask;

    private static final ApiSingleton ourInstance = new ApiSingleton();

    static ApiSingleton getInstance() {
        return ourInstance;
    }

    Context mContext = ApiApplicationLevelClass.getAppContext();

    private ApiSingleton() {
    }
    public static Bus bus = new Bus(ThreadEnforcer.MAIN);


    public static void acceptTask(Task task) {


        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        DriverApi client = retrofit.create(DriverApi.class);

        Call<Task> call = client.acceptTask(authHeader, task); // get driver data

        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {

                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                    Task task = response.body();


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(ApiApplicationLevelClass.getAppContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void getAssignedTasks(final User user) {


        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        DriverApi client = retrofit.create(DriverApi.class);

        Call<List<Task>> call = client.getAssignedTasks(authHeader); // get driver data

        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {

                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                }

            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                Toast.makeText(mContext, "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }

    public static Task getSpecificTask(String taskId) {


        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        final String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        DriverApi client = retrofit.create(DriverApi.class);

        Call<Task> call = client.getSpecificTask(authHeader, taskId); // get driver data

        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {



                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                    resultTask = response.body();

                    Events.FragmentActivityMessage fragmentActivityMessageEvent =
                            new Events.FragmentActivityMessage(response.body().getPickup().getAddress().getCity());

                    GlobalBus.getBus().post(fragmentActivityMessageEvent);

                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Log.e(TAG, "onFailure: failed: " + t );
            }

        });

        return resultTask;
    }

    private void sendMessageToActivity() {
        Events.FragmentActivityMessage fragmentActivityMessageEvent =
                new Events.FragmentActivityMessage("test");

        GlobalBus.getBus().post(fragmentActivityMessageEvent);
    }


    private void startTask(String taskId) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(mContext);


        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        DriverApi client = retrofit.create(DriverApi.class);

        Call<Task> call = client.startTask(authHeader, taskId); // get driver data

        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {

                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                    Task task = response.body();


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(mContext, "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }


    private void arriveAtTask(String taskId) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(mContext);


        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        DriverApi client = retrofit.create(DriverApi.class);

        Call<Task> call = client.arriveTask(authHeader, taskId); // get driver data

        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {

                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                    Task task = response.body();


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(mContext, "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }


    public static void failTask(String taskId, Task task) {

        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        DriverApi client = retrofit.create(DriverApi.class);

        Call<Task> call = client.failTask(authHeader, taskId, task ); // get driver data

        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {

                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                    Task task = response.body();


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(ApiApplicationLevelClass.getAppContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }


    private void completeTask(String taskId) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(mContext);


        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        DriverApi client = retrofit.create(DriverApi.class);

        Call<Task> call = client.completeTask(authHeader, taskId); // get driver data

        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {

                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                    Task task = response.body();

                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(mContext, "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }

    public static List<TaskPayload> getPayloads(String taskId) {

        final List<TaskPayload> list = new LinkedList<>();

        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        DriverApi client = retrofit.create(DriverApi.class);

        Call<List<TaskPayload>> call = client.getPayloadDetails(authHeader, taskId);

        call.enqueue(new Callback<List<TaskPayload>>() {
            @Override
            public void onResponse(Call<List<TaskPayload>> call, Response<List<TaskPayload>> response) {

                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                    for ( TaskPayload payload : response.body() ) {
                        list.add(payload);
                    }

                }

            }

            @Override
            public void onFailure(Call<List<TaskPayload>> call, Throwable t) {

                Log.e(TAG, "onFailure: failed " + t );
            }

        });

        return list;
    }


    // takes in a task for its taskId, and a String referencing a specific payload id
    // response should change the status from a 0 - not checked in,
    // to a 1 - checked in.
    public static void checkInPayload(String payloadId, Task task) {

        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        DriverApi client = retrofit.create(DriverApi.class);

        Call<Task> call = client.payloadCheckIn(authHeader, payloadId, task );

        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {

                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                    Task task = response.body();


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Log.e(TAG, "onFailure: failed " + t );
            }

        });
    }

    public static void checkOutPayload(String payloadId, Task task) {

        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        DriverApi client = retrofit.create(DriverApi.class);

        Call<Task> call = client.payloadCheckOut(authHeader, payloadId, task );

        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {

                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                    Task task = response.body();


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Log.e(TAG, "onFailure: failed " + t );
            }

        });
    }

    public static void uploadTaskFile(File file) {
        // create upload service client

        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();
        DriverApi client = retrofit.create(DriverApi.class);

        // create RequestBody instance from file
        final RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("picture", file.getName(), requestFile);

        // add another part within the multipart request
        String descriptionString = "file";

        // finally, execute the request
        Call<ResponseBody> call = client.uploadTaskFile(authHeader, descriptionString, body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call,
                                   Response<ResponseBody> response) {
                Log.e(TAG, "onResponse: response" );

                ImageResponse imageID;

                if ( response.code() == 200 ) {

                    String  jsonString;
                    try {
                        jsonString = response.body().string();
                        imageID = new Gson().fromJson(jsonString, ImageResponse.class);

                        Log.e(TAG, "onResponse: imageId: " + imageID.getUrl() );

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
            }
        });
    }

    public static void uploadDriverFile(File file) {
        // create upload service client

        String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiOTFkNTI4NzhjMTgxYWRmNDY4OGU2ODA0ZThkODU0NTA2NzUzMmQ0MyIsInRzIjoxNTAwNTg0ODY4fQ.D5A9WaoA-D3B0XWUAlsFHBs0yRJdd5_5gS_1lcxS-WU";


        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token);


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // request everything

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://driver-gateway.gocopia.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();
        DriverApi client = retrofit.create(DriverApi.class);

        // create RequestBody instance from file
        final RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("picture", file.getName(), requestFile);

        // add another part within the multipart request
        String descriptionString = "file";

        // finally, execute the request
        Call<ResponseBody> call = client.uploadDriverFile(authHeader, descriptionString, body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call,
                                   Response<ResponseBody> response) {
                Log.e(TAG, "onResponse: response" );

                ImageResponse imageID;

                if ( response.code() == 200 ) {

                    String  jsonString;
                    try {
                        jsonString = response.body().string();
                        imageID = new Gson().fromJson(jsonString, ImageResponse.class);

                        Log.e(TAG, "onResponse: imageId: " + imageID.getId() );

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
            }
        });
    }
}
