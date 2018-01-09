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

import gts.com.mobile.models.Chauffeur;
import gts.com.mobile.models.Etudiant;

public class EtudiantService {
    private List<Etudiant> etudiants;
    private final static String ENDPOINT = "http://192.168.1.16:8080/rest/etudiants/";
    private Gson gson;
    private RequestQueue requestQueue;

    public EtudiantService(Context context) {
        etudiants = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(context);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("d/M/yy hh:mm a");
        gson = gsonBuilder.create();
        etudiants.clear();
        fetchEtudiants();
    }

    private void fetchEtudiants(){
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT,onEtudiantsLoaded,onEtudiantsError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onEtudiantsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            etudiants = Arrays.asList(gson.fromJson(response,Etudiant[].class));

            for(Etudiant i : etudiants){
                Log.i("Etudiant",i.getNom() );
            }
        }
    };

    private final Response.ErrorListener onEtudiantsError = new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("Etudiants Error:", error.toString());
        }
    };


    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Etudiant login(String email, String password){
        for(Etudiant e : etudiants) {
            if (e.getEmail().equals(email) && e.getPassword().equals(password)) {
                Log.i("Daz mn hnaya", "Aha");
                return e;
            }
        }
        return null;
    }
}
