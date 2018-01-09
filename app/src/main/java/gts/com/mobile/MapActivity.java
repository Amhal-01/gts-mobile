package gts.com.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import gts.com.mobile.models.Chauffeur;
import gts.com.mobile.models.Etudiant;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private Button logout;
    private Etudiant e ;
    private Chauffeur c;
    private List<LatLng> points = new ArrayList<>();

    public void init(){
        points.add(new LatLng(30.933544,-7.981084));
        points.add(new LatLng(31.667971,-8.013291));
        points.add(new LatLng(31.617988,-8.008784));
        points.add(new LatLng(31.659409,-8.008454));
        for(LatLng p : points){
            mMap.addMarker(new MarkerOptions().position(p).title("Point de ramassage").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_stop)));
        }
        LatLng marrakech = new LatLng(31.6341600, -7.9999400);
        mMap.addMarker(new MarkerOptions().position(marrakech).title("École").icon(BitmapDescriptorFactory.fromResource(R.drawable.school)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marrakech, 17.0f));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MapActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        e = getIntent().getParcelableExtra("etudiant");
        c = getIntent().getParcelableExtra("chauffeur");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        init();
    }
}
