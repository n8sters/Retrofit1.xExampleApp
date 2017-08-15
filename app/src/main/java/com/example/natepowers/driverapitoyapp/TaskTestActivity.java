package com.example.natepowers.driverapitoyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;

import java.util.List;

import static com.example.natepowers.driverapitoyapp.Events.*;

public class TaskTestActivity extends AppCompatActivity {

    private static final String TAG = TaskTestActivity.class.getSimpleName();

    TextView mContent;
    Button mGetTasksButton;
    Button displayButton;
    List<TaskPayload> payloadList;
    public static Bus bus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_test);

        mContent = (TextView) findViewById(R.id.content_tv);

        mGetTasksButton = (Button) findViewById(R.id.get_assigned_tasks_button);

        displayButton = (Button) findViewById(R.id.display_button);


        bus = new Bus(ThreadEnforcer.MAIN);
        bus.register(this);

        mGetTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Task task = ApiSingleton.getSpecificTask("_tAfI7vm2Q");
                //bus.post("testing!");
                sendMessageToFragment("test");
            }

        });

        displayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                for (TaskPayload payload : payloadList) {
                    Log.e(TAG, "Payload id: " + payload.getPayloadId() + "\n");
                }
            }
        });


    }


    @Produce
    public String produceEvent() {
        return "Starting up";
    }

    @Subscribe
    public void getMessage(Events.FragmentActivityMessage fragmentActivityMessage) {
        Toast.makeText(getApplicationContext(),
                "message " + fragmentActivityMessage.getMessage(),
                Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onStart() {
        super.onStart();
        GlobalBus.getBus().register(this);
    }


    public void sendMessageToFragment(String message) {
        GlobalBus.getBus().post(message);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GlobalBus.getBus().unregister(this);
    }
}
