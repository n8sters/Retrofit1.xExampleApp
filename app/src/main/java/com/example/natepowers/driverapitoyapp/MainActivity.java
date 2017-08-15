package com.example.natepowers.driverapitoyapp;

import android.content.Intent;
import android.content.SharedPreferences;
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
    String phone = "(650) 223-4780";
    String token;
    int type;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        setContentView(R.layout.activity_main);

        final TextView label = (TextView) findViewById(R.id.textView);
        final EditText phoneEditText = (EditText) findViewById(R.id.editText);

        Button uploadButton = (Button) findViewById(R.id.launch_task_activity_button);

        Button getAccess = (Button) findViewById(R.id.request_access_button);

        Button getToken = (Button) findViewById(R.id.get_token_button);

        Button getType = (Button) findViewById(R.id.get_type_button);

        getAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(phone);
                sendNetworkRequest(user);
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                startActivity(intent);
            }
        });

        getToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //User user = new User();
                //getDriverData(user);
                User user1 = new User(UUID, phoneEditText.getText().toString(), phone);
                requestAccessCode(user1);
                //sendNetworkRequest(user);
            }
        });

        getType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                getDriverData(user);
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TaskTestActivity.class);
                startActivity(intent);
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
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void requestAccessCode(final User user) {

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
                if (response.code() == 200) {
                    // Do awesome stuff
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("session_management", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    String t = response.body().getToken();
                    token = response.body().getToken();
                    editor.putString("token", token );
                    if ( t.length() > 6 ) {
                        editor.putBoolean("isLoggedIn", true); // sets user as logged i
                        Log.e(TAG, "onResponse: User logged in! " );
                    }
                    editor.apply(); // apply changes
                    Log.e(TAG, "onResponse: Token string: " + t);
                    Log.e(TAG, "onResponse: token raw " + response.body().getToken() );
                    User user = new User();
                    getDriverData(user);
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void getDriverData(final User user ) {

        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token );

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
                if (response.code() == 200) {
                    // Do awesome stuff
                    type = response.body().getType();
                    switch (type) {
                        case 1:
                            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                            startActivity(intent);
                    }
                } else {
                    // Handle other response codes
                    Toast.makeText(getApplicationContext(), "Something went wrong here.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setAccess(String s ) {
        token = s;
        SharedPreferences pref = getApplicationContext().getSharedPreferences("session_management", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("token", s); // currently being saves as String value
        if ( s.length() > 6 ) {
            editor.putBoolean("isLoggedIn", true); // sets user as logged i
        }
        editor.apply();
    }
}
