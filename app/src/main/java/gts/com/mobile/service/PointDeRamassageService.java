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

import gts.com.mobile.models.PointDeRamassage;

public class PointDeRamassageService {
    private List<PointDeRamassage> pointDeRamassages;
    private final static String ENDPOINT = "http://192.168.1.16:8080/rest/pointDeRamassages/";
    private Gson gson;
    private RequestQueue requestQueue;

    public PointDeRamassageService(Context context) {
        pointDeRamassages = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(context);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("d/M/yy hh:mm a");
        gson = gsonBuilder.create();
        pointDeRamassages.clear();
        fetchPointDeRamassages();
    }

    private void fetchPointDeRamassages(){
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT,onPointDeRamassagesLoaded,onPointDeRamassagesError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onPointDeRamassagesLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            pointDeRamassages = Arrays.asList(gson.fromJson(response,PointDeRamassage[].class));

            for(PointDeRamassage i : pointDeRamassages){
                Log.i("PointDeRamassage",i.getPoint().getAddress());
            }
        }
    };

    private final Response.ErrorListener onPointDeRamassagesError = new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("PointDeRamassages Error:", error.toString());
        }
    };


    public List<PointDeRamassage> getPointDeRamassages() {
        return pointDeRamassages;
    }

    public void setPointDeRamassages(List<PointDeRamassage> pointDeRamassages) {
        this.pointDeRamassages = pointDeRamassages;
    }
}
