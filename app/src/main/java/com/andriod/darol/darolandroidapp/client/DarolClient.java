package com.andriod.darol.darolandroidapp.client;

import com.andriod.darol.darolandroidapp.Constants;
import com.andriod.darol.darolandroidapp.DarolApplication;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * @author Akbari
 * @version ${VERSION}
 * @since 11/15/2016
 */

public class DarolClient {

    public void authorize(Map<String, String> paramMap,
                          Response.Listener<JSONObject> listener,
                          Response.ErrorListener errorListener) {
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            try {
                jsonObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        String url = Constants.WS + Constants.PORT + "/api/auth";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                url, jsonObject, listener, errorListener);
        Volley.newRequestQueue(
                DarolApplication.getInstance().getApplicationContext()
        )
                .add(request);
    }

    public void registerBuildingCode(String code,
                                     Response.Listener<JSONObject> listener,
                                     Response.ErrorListener errorListener) {
        String url = Constants.WS + Constants.PORT + "/api/register/building/" + code;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url, null, listener, errorListener);
        Volley.newRequestQueue(
                DarolApplication.getInstance().getApplicationContext()
        )
                .add(request);
    }
}
