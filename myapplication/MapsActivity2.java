package com.example.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Main3Activity main3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        main3=new Main3Activity();
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
        LatLng sydney = new LatLng(28.561522, 77.315965);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Maharishi Mandir Marg"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,10F));

        LatLng sydney1 = new LatLng(28.553359, 77.295867);
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Abdul Fazal Phase I new Delhi 110025"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney1,10F));

        LatLng sydney2 = new LatLng(28.473186, 77.481974);
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Sharda University"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney2,10F));

        LatLng sydney3 = new LatLng(28.641117, 77.227699);
        mMap.addMarker(new MarkerOptions().position(sydney3).title("North Delhi Municipal Corporate").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney3,10F));

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
