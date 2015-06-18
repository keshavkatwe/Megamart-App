package com.dynasofts.megamart.Pojo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dynasofts.megamart.Network.VolleySingleton;

/**
 * Created by Keshav K on 6/18/2015.
 */
public class User {
    private int user_id;
    private String fullname;
    private String password;
    private String birthday;
    private String gender;
    private String phone;
    private String date_log;


    public User(String fullname, String password, String birthday, String gender, String phone, String date_log) {
        this.fullname = fullname;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.date_log = date_log;
    }

    public void save()
    {
        RequestQueue mRequestQueue = VolleySingleton.getInstance().getmRequestQueue();
        StringRequest mStringRequest = new StringRequest(Request.Method.GET, "http://php.net/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(mStringRequest);
    }
}
