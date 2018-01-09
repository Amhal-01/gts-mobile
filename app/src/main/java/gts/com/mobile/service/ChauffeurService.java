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
import java.util.Objects;

import gts.com.mobile.models.Chauffeur;
import gts.com.mobile.models.Etudiant;

public class ChauffeurService {
    private List<Chauffeur> chauffeurs = new ArrayList<>();
    private final static String ENDPOINT = "http://192.168.1.157:8080/rest/chauffeurs/";
    private Gson gson;
    private RequestQueue requestQueue;

    public ChauffeurService(Context context) {
        requestQueue = Volley.newRequestQueue(context);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("d/M/yy hh:mm a");
        gson = gsonBuilder.create();
        fetchChauffeurs();
    }

    private void fetchChauffeurs() {
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, onChauffeursLoaded, onChauffeursError);
        requestQueue.add(request);
    }

    public List<Chauffeur> getChauffeurs() {
        return chauffeurs;
    }

    public void setChauffeurs(List<Chauffeur> chauffeurs) {
        this.chauffeurs = chauffeurs;
    }

    private final Response.Listener<String> onChauffeursLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            setChauffeurs(Arrays.asList(gson.fromJson(response, Chauffeur[].class)));
            Log.i("onReponse Chauffeur", "Réussite");
            Log.i("Chauffeur", getChauffeurs().toString());
        }
    };

    private final Response.ErrorListener onChauffeursError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("Chauffeurs Error:", error.toString());
        }
    };

    public Chauffeur login(String email, String password) {
        Log.i("Daz mn hnaya", "Aha");
        return chauffeurs.get(0);
    }
}
