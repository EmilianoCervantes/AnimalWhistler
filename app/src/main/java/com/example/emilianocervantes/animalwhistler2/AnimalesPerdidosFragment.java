package com.example.emilianocervantes.animalwhistler2;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalesPerdidosFragment extends Fragment implements OnMapReadyCallback {

    private final int REQUEST_LOCATION_CODE = 99;
    private Button acercar;
    private Button alejar;

    GoogleMap map;
    private GoogleApiClient googleApiClient;

    public AnimalesPerdidosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animales_perdidos, container, false);
        acercar = (Button)view.findViewById(R.id.acercar);
        alejar = (Button)view.findViewById(R.id.alejar);

        acercar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });

        alejar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment supportMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;


        LatLng perrera1 = new LatLng(19.3353482,  -99.12309549999998);
        LatLng perrera2 = new LatLng(19.2824725,  -99.0505124);
        LatLng perrera3 = new LatLng(19.3016444,  -99.08675410000001);
        LatLng perrera4 = new LatLng(19.3618761,  -99.21357769999997);
        LatLng perrera5 = new LatLng(19.3624137,  -99.14864039999998);
        MarkerOptions options1 = new MarkerOptions();
        MarkerOptions options2 = new MarkerOptions();
        MarkerOptions options3 = new MarkerOptions();
        MarkerOptions options4 = new MarkerOptions();
        MarkerOptions options5 = new MarkerOptions();
        options1.position(perrera1).title("Centro de Control Canino Dr. Alfonso A. Ellini de la Garza").snippet("Telefono: 01 55 5607 4093");
        options2.position(perrera2).title("Centro de Control Canino").snippet("Telefono: 01 55 2160 5439");
        options3.position(perrera3).title("Brigada de Vigilancia Animal").snippet("Telefono: 01 55 5208 9898");
        options4.position(perrera4).title("EsculCan").snippet("Telefono: 01 55 9197 4685");
        options5.position(perrera5).title("Protectora Nacional de Animales").snippet("Telefono: 01 55 5604 2482");
        map.addMarker(options1);
        map.addMarker(options2);
        map.addMarker(options3);
        map.addMarker(options4);
        map.addMarker(options5);
        map.moveCamera(CameraUpdateFactory.newLatLng(perrera1));

    }

}
