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

import java.io.File;
import java.util.List;

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

public class TaskTestActivity extends AppCompatActivity {

    private static final String TAG = TaskTestActivity.class.getSimpleName();

    TextView mContent;
    Button mGetTasksButton;
    Button displayButton;
    List<TaskPayload> payloadList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_test);

        mContent = (TextView) findViewById(R.id.content_tv);

        mGetTasksButton = (Button) findViewById(R.id.get_assigned_tasks_button);

        displayButton = (Button) findViewById(R.id.display_button);

        mGetTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               File f = new File("/storage/emulated/0/Pictures/1502769319395.jpg");
                ApiSingleton.uploadDriverFile(f);


            }
        });

        displayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                for ( TaskPayload payload : payloadList ) {
                    Log.e(TAG, "Payload id: " + payload.getPayloadId() + "\n" );
                }
            }
        });

    }


}
