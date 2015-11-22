package com.example.davidmerillas.mapsapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng radMas = new LatLng(40.3690659, -3.743091);

        /*
        * Añadimos los marcadores y les cambiamos el color segun lo que sean
        *
        * -Azul: RadMas
        * -Rojo: Centro comercial
        * -Verde: Centro de salud
        *
        * */

        mMap.addMarker(new MarkerOptions().position(radMas).title("RadMas")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.363738, -3.739509))
                .title("Islazul").snippet("Centro comercial"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.3710616, -3.746832))
                .title("Medina").snippet("Centro comercial"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.3729641, -3.7476666))
                .title("Centro de Salud Guayaba").snippet("Centro de especialidades")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        //Movemos la camara hacia donde esta la empresa y hacemos zoom
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                .target(radMas).zoom(15).build()));
    }
}
