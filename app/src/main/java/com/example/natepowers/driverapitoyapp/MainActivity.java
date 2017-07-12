package com.example.natepowers.driverapitoyapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    protected final String TAG = getClass().getSimpleName();
    private RetainedAppData mRetainedAppData;
    // UX handlers
    private ProgressBar mProgressBar;
    private EditText    mInputCityName;
    private TextView    mCityNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar_id);
        mInputCityName = (EditText) findViewById(R.id.input_city_id);
        // Data saved
        if (savedInstanceState != null) {
            if (getLastCustomNonConfigurationInstance() != null) {
                mRetainedAppData = (RetainedAppData) getLastCustomNonConfigurationInstance();
                Log.d(TAG,"onCreate(): Reusing retained data set");
            }
        } else {
            mRetainedAppData = new RetainedAppData();
            Log.d(TAG, "onCreate(): Creating new  data set");
        }

        // Setup activity reference
        // mActivityRef = new WeakReference<>(this);
        mRetainedAppData.setAppContext(this);

        if (mRetainedAppData.mData != null) {
            updateUXWithWeatherData(mRetainedAppData.mData);
        }
        // Setup the progress bar
        if  (mRetainedAppData.isFetchInProgress()) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // mActivityRef = null;
        mRetainedAppData.setAppContext(null);
        Log.d(TAG,"onDestroy()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mRetainedAppData;
    }

    public void expandWeatherAsync(View v) {
        hideKeyboard(MainActivity.this, mInputCityName.getWindowToken());
        String city = mInputCityName.getText().toString();
        if (city.isEmpty()) {
            Toast.makeText(getApplicationContext(),"No city specified.",
                    Toast.LENGTH_LONG).show();
            return;
        }
        mRetainedAppData.runRetrofitTestAsync(city);
    }

    /**
     * This method is used to hide a keyboard after a user has
     * finished typing the url.
     */
    public static void hideKeyboard(Activity activity,
                                    IBinder windowToken) {
        InputMethodManager mgr = (InputMethodManager) activity.getSystemService
                (Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(windowToken, 0);
    }

    void updateUXWithWeatherData (final DriverData data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Setup UX handlers
                // Get the UX handlers every time. This is to avoid a condition
                // when runOnUiThread may not have updated UX handles when screen is rotated.
                // 'mActivityRef.get()'
                mProgressBar = (ProgressBar) findViewById(R.id.progress_bar_id);
                mInputCityName = (EditText) findViewById(R.id.input_city_id);
                mCityNameTextView = (TextView) findViewById(R.id.city_name_id);
                // Refresh UX data
                if (mRetainedAppData.isFetchInProgress()) {
                    mProgressBar.setVisibility(View.VISIBLE);
                } else {
                    mProgressBar.setVisibility(View.INVISIBLE);
                }

                // Print data to Android display
                Resources res = getResources();
                String textToPrint = res.getString(R.string.city) + data.getLastName();
                mCityNameTextView.setText(textToPrint);
            }
        });
    }

    /**
     * This is main class object that should save all data upon configuration changes.
     * This object is saved by the 'onRetainCustomNonConfigurationInstance' method.
     *
     * Note: In the video it is referred to as 'private class TestWeatherData'
     */
    private static class RetainedAppData {
        private  WeakReference<MainActivity> mActivityRef;
        protected final String TAG = "RTD";
        private DriverData mData; // Weather data received
        private AtomicBoolean mInProgress = new AtomicBoolean(false); // Is a download in progress
        private DriverRestAdapter mWeatherRestAdapter; // REST Adapter
        private Callback<DriverData> mWeatherDataCallback = new Callback<DriverData>() {
            @Override
            public void success(DriverData data, Response response) {

                mData = data;
                if (mActivityRef.get() != null) {
                    mActivityRef.get().updateUXWithWeatherData(mData);
                    mActivityRef.get().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mActivityRef.get().mProgressBar = (ProgressBar) mActivityRef.get().
                                    findViewById(R.id.progress_bar_id);
                            mActivityRef.get().mProgressBar.setVisibility(View.INVISIBLE);
                        }
                    });
                }
                mInProgress.set(false);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG,"failure: " + error);
                mInProgress.set(false);
                if (mActivityRef.get() != null) {
                    mActivityRef.get().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mActivityRef.get().mProgressBar = (ProgressBar) mActivityRef.get().
                                    findViewById(R.id.progress_bar_id);
                            mActivityRef.get().mProgressBar.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
        };
        // Method to test Async. call
        public void runRetrofitTestAsync (final String city) {
            if ( (mActivityRef.get() != null) && (mInProgress.get())) {
                Toast.makeText(mActivityRef.get(),"Weather fetch in progress.",
                        Toast.LENGTH_LONG).show();
                return;
            }
            // Get the Adapter
            if (mWeatherRestAdapter == null)
                mWeatherRestAdapter = new DriverRestAdapter();

            if (mActivityRef.get() != null) {
                mActivityRef.get().mProgressBar.setVisibility(View.VISIBLE);
            }

            // Test delay
            try {
                mInProgress.set(true);
                mWeatherRestAdapter.testDriverApi(city, mWeatherDataCallback); // Call Async API
            } catch (Exception e) {
                Log.d(TAG, "Thread sleep error" + e);
            }
        }

        void setAppContext (MainActivity ref) {
            mActivityRef = new WeakReference<>(ref);
        }

        boolean isFetchInProgress() {
            return mInProgress.get();
        }
    }
}
