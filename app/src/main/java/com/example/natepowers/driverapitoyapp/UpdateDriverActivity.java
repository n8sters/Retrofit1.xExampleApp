package com.example.natepowers.driverapitoyapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateDriverActivity extends AppCompatActivity {

    private static final String TAG = UpdateDriverActivity.class.getSimpleName();

    EditText mFirstName;
    EditText mLastName;
    Button mSendButton;

    String firstName;
    String lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_driver);


        mFirstName = (EditText) findViewById(R.id.first_name_edit_text);
        mLastName = (EditText) findViewById(R.id.last_name_edit_text);
        mSendButton = (Button) findViewById(R.id.send_button);

        final SharedPreferences prefs = getApplicationContext().getSharedPreferences("user_data", 0); // 0 - for private mode
        if (prefs.getString("driverFirstName", null) != null) {
            mFirstName.setText(prefs.getString("driverFirstName", null));
        } else {
            mFirstName.setText("");
        }
        mFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //// TODO: 7/20/17
            }

            @Override
            public void afterTextChanged(Editable editable) {
                firstName = mFirstName.getText().toString();
            }
        });
        if (prefs.getString("driverLastName", null) != null) {
            mLastName.setText(prefs.getString("driverLastName", null));
        } else {
            mLastName.setText("");
        }
        mLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // // TODO: 7/20/17
            }

            @Override
            public void afterTextChanged(Editable editable) {
                lastName = mLastName.getText().toString();
            }
        });

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(firstName, lastName, null, null);
                updateDriverInfo(user);
            }
        });
    }

    private void updateDriverInfo(User user) {


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

        Call<User> call = client.updateDriver(authHeader, user); // get driver data

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
               if( response.code() == 200 ) {
                   Toast.makeText(UpdateDriverActivity.this, "It worked!", Toast.LENGTH_SHORT).show();
               }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });

    }

}
