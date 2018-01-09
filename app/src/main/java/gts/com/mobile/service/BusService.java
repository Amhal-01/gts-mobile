package gts.com.mobile.service;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gts.com.mobile.models.Bus;

public class BusService {
    private List<Bus> buss;
    private final static String ENDPOINT = "http://192.168.1.16:8080/rest/buss/";
    private Gson gson;
    private RequestQueue requestQueue;

    public BusService(Context context) {
        buss = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(context);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("d/M/yy hh:mm a");
        gson = gsonBuilder.create();
        buss.clear();
        fetchBuss();
    }

    private void fetchBuss(){
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT,onBussLoaded,onBussError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onBussLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            buss = Arrays.asList(gson.fromJson(response,Bus[].class));

            for(Bus i : buss){
                Log.i("Bus",i.getMatricule());
            }
        }
    };

    private final Response.ErrorListener onBussError = new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("Buss Error:", error.toString());
        }
    };


    public List<Bus> getBuss() {
        return buss;
    }

    public void setBuss(List<Bus> buss) {
        this.buss = buss;
    }
}
