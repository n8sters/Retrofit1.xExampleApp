package com.example.natepowers.driverapitoyapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by natepowers on 8/14/17.
 */

public class ApiApplicationLevelClass extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        ApiApplicationLevelClass.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return ApiApplicationLevelClass.context;
    }
}
