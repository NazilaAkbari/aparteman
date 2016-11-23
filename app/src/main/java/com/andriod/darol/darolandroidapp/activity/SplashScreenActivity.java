package com.andriod.darol.darolandroidapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andriod.darol.darolandroidapp.Constants;
import com.andriod.darol.darolandroidapp.DarolApplication;
import com.andriod.darol.darolandroidapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferences sharedPreferences = DarolApplication.getInstance()
                .getSharedPreferences();
        if (sharedPreferences.getBoolean(Constants.PREF_IS_LOGGED_IN, false))
            startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        else
            startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));


    }
}
