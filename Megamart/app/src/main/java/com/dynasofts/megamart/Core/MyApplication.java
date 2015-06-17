package com.dynasofts.megamart.Core;

import android.app.Application;
import android.content.Context;

/**
 * Created by Keshav K on 6/17/2015.
 */
public class MyApplication extends Application {
    private static MyApplication sInstance;

    public static MyApplication getsInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }


    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }

}
