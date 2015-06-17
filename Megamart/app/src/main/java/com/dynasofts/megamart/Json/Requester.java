package com.dynasofts.megamart.Json;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.dynasofts.megamart.Logging.L;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Keshav K on 6/17/2015.
 */
public class Requester {
    public static JSONArray sendJsonArrayRequest(RequestQueue requestQueue, String url) {

        JSONArray response = null;
        RequestFuture<JSONArray> requestFuture = RequestFuture.newFuture();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url,
                (String) null,
                requestFuture, requestFuture);
        requestQueue.add(request);

        try {
            response = requestFuture.get(30000, TimeUnit.MILLISECONDS);
            L.m(response.toString());

        } catch (InterruptedException e) {
            L.m(e + "");
        } catch (ExecutionException e) {
            L.m(e + "");
        } catch (TimeoutException e) {
            L.m(e + "");
        }


        return response;
    }


    public static JSONObject sendJsonObjectRequest(RequestQueue requestQueue, String url) {

        JSONObject response = null;
        RequestFuture<JSONObject> requestFuture = RequestFuture.newFuture();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url,
                (String) null,
                requestFuture, requestFuture);
        requestQueue.add(request);

        try {
            response = requestFuture.get(30000, TimeUnit.MILLISECONDS);
            L.m(response.toString());

        } catch (InterruptedException e) {
            L.m(e + "");
        } catch (ExecutionException e) {
            L.m(e + "");
        } catch (TimeoutException e) {
            L.m(e + "");
        }

        return response;
    }
}
