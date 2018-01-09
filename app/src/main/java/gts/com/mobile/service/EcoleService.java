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

import gts.com.mobile.models.Ecole;

public class EcoleService {
    private List<Ecole> ecoles;
    private final static String ENDPOINT = "http://192.168.1.16:8080/rest/ecoles/";
    private Gson gson;
    private RequestQueue requestQueue;

    public EcoleService(Context context) {
        ecoles = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(context);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("d/M/yy hh:mm a");
        gson = gsonBuilder.create();
        ecoles.clear();
        fetchEcoles();
    }

    private void fetchEcoles(){
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT,onEcolesLoaded,onEcolesError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onEcolesLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            ecoles = Arrays.asList(gson.fromJson(response,Ecole[].class));

            for(Ecole i : ecoles){
                Log.i("Ecole",i.getNom());
            }
        }
    };

    private final Response.ErrorListener onEcolesError = new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("Ecoles Error:", error.toString());
        }
    };


    public List<Ecole> getEcoles() {
        return ecoles;
    }

    public void setEcoles(List<Ecole> ecoles) {
        this.ecoles = ecoles;
    }
}
