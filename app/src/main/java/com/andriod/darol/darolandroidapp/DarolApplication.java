package com.andriod.darol.darolandroidapp;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author Akbari
 * @version ${VERSION}
 * @since 11/13/2016
 */

public class DarolApplication extends Application {

    private static DarolApplication instance;
    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public static DarolApplication getInstance() {
        return instance;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
