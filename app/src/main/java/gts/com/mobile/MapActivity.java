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

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button profile, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        logout = findViewById(R.id.logout);
        profile = findViewById(R.id.profile);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MapActivity.this, ErrorActivity.class);
                startActivity(i);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MapActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng marrakech = new LatLng(31.6341600, -7.9999400);
        mMap.addMarker(new MarkerOptions().position(marrakech).title("Marker in Marrakech").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_marker)));
        /*mMap.moveCamera(CameraUpdateFactory.newLatLng(marrakech));*/
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marrakech, 17.0f));
    }
}
