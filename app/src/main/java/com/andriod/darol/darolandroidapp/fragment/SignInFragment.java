package com.andriod.darol.darolandroidapp.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.andriod.darol.darolandroidapp.R;
import com.andriod.darol.darolandroidapp.client.DarolClient;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignInFragment extends DialogFragment {

    private EditText username;
    private EditText password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(
                inflater.inflate(R.layout.fragment_sign_in, null)
        )
                .setPositiveButton(R.string.enter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        username = (EditText) getDialog().
                                findViewById(R.id.username);
                        password = (EditText) getDialog().
                                findViewById(R.id.password);
                        if (!(username.equals("") && password.equals(""))) {
                            Map<String, String> paramMap = new HashMap<>();
                            paramMap.put("username", username.getText().toString());
                            paramMap.put("password", password.getText().toString());
                            DarolClient darolClient = new DarolClient();
                            darolClient.authorize(paramMap,
                                    new Response.Listener<JSONObject>() {
                                        @Override
                                        public void onResponse(JSONObject response) {
                                            System.out.println("Yes");
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            System.out.println("NO");
                                        }
                                    }
                            );
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SignInFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
