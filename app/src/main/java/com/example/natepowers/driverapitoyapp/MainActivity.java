package com.example.natepowers.driverapitoyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();

    String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
    String phone = "(650)223-4780";
    String access = "855668";
    String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiM2EyY2UyMjY0ZjE0ZTM1ZjgxNGZjZDA4NGMxZTFmZDlkNmNmYWI3OCIsInRzIjoxNDk5OTkwOTc1fQ.OKJlQxNgYOkaaO9TwjxZg4z1GBBlxl38qB-f1EbjKWw";
    String token;
    String base = UUID + ":" + accessToken;
    String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);
    String type;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        setContentView(R.layout.activity_main);

        final TextView label = (TextView) findViewById(R.id.textView);
        final EditText phoneEditText = (EditText) findViewById(R.id.editText);



        Button makeRequest = (Button) findViewById(R.id.button);
        makeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                getDriverData(user);
                //User user = new User(phone);
                //sendNetworkRequest(user);
            }
        });
    }

    private void sendNetworkRequest( User user) {
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
        Call<User> call = client.requestAccessCode(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //Toast.makeText(MainActivity.this, "It worked! Token: " + Boolean.toString(response.body().wasSuccess()), Toast.LENGTH_SHORT).show();
                //Log.e(TAG, "onResponse: " +  response.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void logUserIn(final User user) {

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

        Call<User> call = client.requestToken(user); // request access code

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // TODO disable fab until a token is returned
                token = response.body().getToken();
                Log.e(TAG, "onResponse: Token: " + token );

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getDriverData( User user ) {

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

        Call<User> call = client.getDriverInfo(authHeader); // get driver data

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this, "Yay!", Toast.LENGTH_SHORT).show();
                type = response.body().getType();
                Toast.makeText(MainActivity.this, "Type: " + type, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
