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

import gts.com.mobile.models.Itineraire;

public class ItineraireService {
    private List<Itineraire> itineraires;
    private final static String ENDPOINT = "http://192.168.1.16:8080/rest/itineraires/";
    private Gson gson;
    private RequestQueue requestQueue;

    public ItineraireService(Context context) {
        itineraires = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(context);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("d/M/yy hh:mm a");
        gson = gsonBuilder.create();
        itineraires.clear();
        fetchItineraires();
    }

    private void fetchItineraires(){
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT,onItinerairesLoaded,onItinerairesError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onItinerairesLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            itineraires = Arrays.asList(gson.fromJson(response,Itineraire[].class));

            for(Itineraire i : itineraires){
                Log.i("Itineraire",i.getLon()+" , "+i.getLat());
            }
        }
    };

    private final Response.ErrorListener onItinerairesError = new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("Itineraires Error:", error.toString());
        }
    };


    public List<Itineraire> getItineraires() {
        return itineraires;
    }

    public void setItineraires(List<Itineraire> itineraires) {
        this.itineraires = itineraires;
    }
}
