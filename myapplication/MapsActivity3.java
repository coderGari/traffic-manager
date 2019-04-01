package com.example.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity3 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps3);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(28.479171, 77.512055);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Rayan chowk"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,13F));

        LatLng sydney1 = new LatLng(28.473012, 77.516576);
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Golf Cours"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney1,13F));

        LatLng sydney2 = new LatLng(28.474894, 77.509505);
        mMap.addMarker(new MarkerOptions().position(sydney2).title("B/311, 5th cross street"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney2,13F));

        LatLng sydney3 = new LatLng(28.464266, 77.507927);
        mMap.addMarker(new MarkerOptions().position(sydney3).title("Pari Chowk"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney3,13F));
    }
}
