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

import gts.com.mobile.models.RespEcole;

public class RespEcoleService {
    private List<RespEcole> respEcoles;
    private final static String ENDPOINT = "http://192.168.1.16:8080/rest/respEcoles/";
    private Gson gson;
    private RequestQueue requestQueue;

    public RespEcoleService(Context context) {
        respEcoles = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(context);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("d/M/yy hh:mm a");
        gson = gsonBuilder.create();
        respEcoles.clear();
        fetchRespEcoles();
    }

    private void fetchRespEcoles(){
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT,onRespEcolesLoaded,onRespEcolesError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onRespEcolesLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            respEcoles = Arrays.asList(gson.fromJson(response,RespEcole[].class));

            for(RespEcole i : respEcoles){
                Log.i("RespEcole",i.getNom());
            }
        }
    };

    private final Response.ErrorListener onRespEcolesError = new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("RespEcoles Error:", error.toString());
        }
    };


    public List<RespEcole> getRespEcoles() {
        return respEcoles;
    }

    public void setRespEcoles(List<RespEcole> respEcoles) {
        this.respEcoles = respEcoles;
    }
}
