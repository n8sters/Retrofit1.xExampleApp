package com.example.natepowers.driverapitoyapp;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    public String TAG = DetailActivity.class.getSimpleName();

    TextView taskLabel;
    Button getTasksButton;
    String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
    String phone = "(650) 223-4780";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        taskLabel = (TextView) findViewById(R.id.tasks_label_tv);
        getTasksButton = (Button) findViewById(R.id.get_tasks_button);

        getTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                getAvailableTasks(user);
            }
        });

    }

    private void getAvailableTasks(final User user ) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String token = sharedPref.getString("token", null);

        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token );


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

        Call<User> call = client.getTasks(authHeader); // get driver data

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    // Do awesome stuff
                    Toast.makeText(DetailActivity.this, "It worked!", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle other response codes
                    Toast.makeText(getApplicationContext(), "Something went wrong here.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(DetailActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void uploadPicture(Uri fileUri, User user) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String token = sharedPref.getString("token", null);

        Log.e(TAG, "getAvailableTasks: Token at getAvailableTasks " + token );


        String base = UUID + ":" + token;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP); // encode login

        Log.e(TAG, "getDriverData: token at start of getDriverData " + token );

        Object filePath;

        File file = new File(fileUri.toString());
        RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("upload", file.getName(), reqFile);
        RequestBody name = RequestBody.create(MediaType.parse("text/plain"), "upload_test");
        RequestBody picture = RequestBody.create(
                MediaType.parse(getContentResolver().getType(fileUri)),
                file);

        MultipartBody.Part part = MultipartBody.Part.createFormData("photo", file.getName(), picture );


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

        Call<User> call = client.uploadDriverPicture(authHeader, part); // get driver data

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    // Do awesome stuff
                    Toast.makeText(DetailActivity.this, "It worked!", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle other response codes
                    Toast.makeText(getApplicationContext(), "Something went wrong here.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(DetailActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
