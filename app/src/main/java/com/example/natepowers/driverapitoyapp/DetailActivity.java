package com.example.natepowers.driverapitoyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    public String TAG = DetailActivity.class.getSimpleName();

    TextView taskLabel;
    TextView filePathTextView;
    TextView apiResponseTv;
    Button getTasksButton;
    Button takePictureButton;
    Button uploadButton;
    ImageView imageView;
    String UUID = "557264d2-ee65-41a9-b3b5-83d205562431";
    String phone = "(650) 223-4780";
    String mFilePath;
    String token;
    File mFile;

    private static final int CAMERA_REQUEST = 8090;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        taskLabel = (TextView) findViewById(R.id.tasks_label_tv);
        filePathTextView = (TextView) findViewById(R.id.file_path_tv);
        apiResponseTv = (TextView) findViewById(R.id.api_response_tv);
        getTasksButton = (Button) findViewById(R.id.get_tasks_button);
        uploadButton = (Button) findViewById(R.id.launch_task_activity_button);
        takePictureButton = (Button) findViewById(R.id.take_picture_button);
        imageView = (ImageView) findViewById(R.id.imageView);

        getTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                getAvailableTasks(user);
            }
        });

        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, CAMERA_REQUEST);
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("session_management", 0);
                Toast.makeText(DetailActivity.this, "User logged in status: " + prefs.getBoolean("isLoggedIn", false), Toast.LENGTH_SHORT).show();

            }
        });

        SharedPreferences prefs = getSharedPreferences("session_management", 0);
        boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);


        filePathTextView.setText(String.valueOf(isLoggedIn));

    }

    private void getAvailableTasks(final User user) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String token = sharedPref.getString("token", null);

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

        Call<List<Task>> call = client.getAvailableTasks(authHeader); // get driver data

        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                Log.e(TAG, "onResponse: " + response.body().toString());

                String result = response.body().toString();

                List<Task> tasks = response.body();

                Task[] arr = new Task[tasks.size()];
                arr = tasks.toArray(arr);

                for( Task t : arr ) {
                    Log.e(TAG, "onResponse: Task id: " + t.getTaskId() );
                }

            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void logUserOut( final User user ) {

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        token = sharedPref.getString("token", null);

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

        Call<User> call = client.logUserOut(authHeader); // request access code

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    // Do awesome stuff
                    Log.e(TAG, "onResponse: " + response.body().isSuccess());
                    Toast.makeText(DetailActivity.this, "Result: " + response.body().isSuccess(), Toast.LENGTH_SHORT).show();
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("session_management", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("isLoggedIn", false);
                    editor.apply();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(DetailActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
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


    private void updateDriverInfo( User user ) {


        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String token = sharedPref.getString("token", null);

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

        Call<List<Task>> call = client.getAvailableTasks(authHeader); // get driver data

        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                Log.e(TAG, "onResponse: " + response.body().toString());

                String result = response.body().toString();

                List<Task> tasks = response.body();

                Task[] arr = new Task[tasks.size()];
                arr = tasks.toArray(arr);

                for( Task t : arr ) {
                    Log.e(TAG, "onResponse: Task id: " + t.getTaskId() );
                }

            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "OnFailure Triggered", Toast.LENGTH_SHORT).show();

            }

        });




    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);


            // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
            Uri tempUri = getImageUri(getApplicationContext(), photo);

            // CALL THIS METHOD TO GET THE ACTUAL PATH
            File finalFile = new File(getRealPathFromURI(tempUri));

            ApiSingleton.uploadDriverFile(finalFile);

            mFile = finalFile;
            mFilePath = finalFile.toString();
            filePathTextView.setText(mFilePath);


            Log.e(TAG, "onActivityResult: FilePath: " + finalFile.toString());
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }
}
