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

public class EnterBuildingCodeDialogFragment extends DialogFragment {

    private EditText buildingCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(
                inflater.inflate(R.layout.fragment_enter_building_code_dialog, null)
        )
                .setPositiveButton(R.string.enter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        buildingCode = (EditText) getDialog().
                                findViewById(R.id.buildingCode);
                        if (buildingCode != null &&
                                !buildingCode.getText().toString().equals("")) {
                            DarolClient darolClient = new DarolClient();
                            darolClient.registerBuildingCode(buildingCode.getText().toString(),
                                    new Response.Listener<JSONObject>() {
                                        @Override
                                        public void onResponse(JSONObject response) {
                                            System.out.println("YESSSSS");
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            System.out.println("NOOOOOOO"+error.getMessage());
                                        }
                                    });
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EnterBuildingCodeDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
