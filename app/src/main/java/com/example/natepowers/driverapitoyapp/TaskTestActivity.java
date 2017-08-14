package com.example.natepowers.driverapitoyapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaskTestActivity extends AppCompatActivity {

    private static final String TAG = TaskTestActivity.class.getSimpleName();

    TextView mContent;
    Button mGetTasksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_test);

        mContent = (TextView) findViewById(R.id.content_tv);

        mGetTasksButton = (Button) findViewById(R.id.get_assigned_tasks_button);

        mGetTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task("mmA4SRZP_g");
                ApiSingleton.getPayloads("kJcLWO1Inw");
            }
        });

    }

    private void getAssignedTasks(final User user) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


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
                    if (response.body().size() > 1) {
                        Log.e(TAG, "onResponse: " + response.body().toString());

                        List<Task> tasks = response.body();

                        Task[] arr = new Task[tasks.size()];
                        arr = tasks.toArray(arr);

                        for (Task t : arr) {
                            mContent.setText(t.getPickup().getAddress().getDirections());
                        }

                    } else {
                        mContent.setText(response.body().toString());
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void getSpecificTask(String taskId) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


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

        Call<Task> call = client.getSpecificTask(authHeader, taskId); // get driver data

        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {

                if (response.code() == 200) {

                    Log.e(TAG, "onResponse: " + response.body().toString());

                    Task task = response.body();

                    mContent.setText(task.getPickup().getAddress().getDirections());


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void acceptTask(Task task) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


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

                    mContent.setText(task.getPickup().getAddress().getDirections());


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void startTask(String taskId) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


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

                    mContent.setText(task.getPickup().getAddress().getDirections());


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }


    private void arriveAtTask(String taskId) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


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

                    mContent.setText(task.getPickup().getAddress().getDirections());


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }



    private void completeTask(String taskId) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


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

                    mContent.setText(task.getPickup().getAddress().getDirections());


                }

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }


}
