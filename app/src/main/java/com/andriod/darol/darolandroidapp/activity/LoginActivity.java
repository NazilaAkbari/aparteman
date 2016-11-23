package com.andriod.darol.darolandroidapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.andriod.darol.darolandroidapp.R;
import com.andriod.darol.darolandroidapp.fragment.EnterBuildingCodeDialogFragment;
import com.andriod.darol.darolandroidapp.fragment.SignInFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void openEnterCodeDialog(View view) {
        new EnterBuildingCodeDialogFragment().
                show(getSupportFragmentManager(), "enterCode");
    }

    public void openSignInDialog(View view) {
        new SignInFragment().
                show(getSupportFragmentManager(), "signIn");
    }
}

