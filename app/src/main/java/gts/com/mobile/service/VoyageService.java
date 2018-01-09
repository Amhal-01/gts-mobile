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

import gts.com.mobile.models.Voyage;

public class VoyageService {
    private List<Voyage> voyages;
    private final static String ENDPOINT = "http://192.168.1.16:8080/rest/voyages/";
    private Gson gson;
    private RequestQueue requestQueue;

    public VoyageService(Context context) {
        voyages = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(context);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("d/M/yy hh:mm a");
        gson = gsonBuilder.create();
        voyages.clear();
        fetchVoyages();
    }

    private void fetchVoyages(){
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT,onVoyagesLoaded,onVoyagesError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onVoyagesLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            voyages = Arrays.asList(gson.fromJson(response,Voyage[].class));

            for(Voyage i : voyages){
                Log.i("Voyage",i.getClass().getName());
            }
        }
    };

    private final Response.ErrorListener onVoyagesError = new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("Voyages Error:", error.toString());
        }
    };


    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }
}
