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



        LatLng latLng = new LatLng(19.4284700,  -99.1276600);
        MarkerOptions options = new MarkerOptions();
        options.position(latLng).title("CDMX");
        map.addMarker(options);
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));

    }

    public void funcionesMapa(View view){
        switch(view.getId()){
            case R.id.acercar:
                map.animateCamera(CameraUpdateFactory.zoomIn());
                break;
            case R.id.alejar:
                map.animateCamera(CameraUpdateFactory.zoomOut());
                break;
        }
    }
}
