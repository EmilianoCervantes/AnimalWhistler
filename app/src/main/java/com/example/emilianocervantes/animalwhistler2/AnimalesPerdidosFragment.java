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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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
        LatLng perrera6 = new LatLng(19.3104461,  -99.1179467);
        LatLng perrera7 = new LatLng(19.3104461,  -99.1267014);
        LatLng perrera8 = new LatLng(19.3919868,  -99.1663153);
        LatLng perrera9 = new LatLng(19.4601432,  -99.2042924);
        LatLng perrera10 = new LatLng(19.3538868,  -99.1542576);
        LatLng perrera11 = new LatLng(19.3848117,  -99.1921948);
        LatLng perrera12 = new LatLng(19.384805,  -99.1921948);
        LatLng perrera13 = new LatLng(19.3957589,  -99.0989942);
        LatLng perrera14 = new LatLng(19.4311851,  -99.2513104);
        LatLng perrera15 = new LatLng(19.5268846,  -99.2217854);
        MarkerOptions options1 = new MarkerOptions();
        MarkerOptions options2 = new MarkerOptions();
        MarkerOptions options3 = new MarkerOptions();
        MarkerOptions options4 = new MarkerOptions();
        MarkerOptions options5 = new MarkerOptions();
        MarkerOptions options6 = new MarkerOptions();
        MarkerOptions options7 = new MarkerOptions();
        MarkerOptions options8 = new MarkerOptions();
        MarkerOptions options9 = new MarkerOptions();
        MarkerOptions options10 = new MarkerOptions();
        MarkerOptions options11 = new MarkerOptions();
        MarkerOptions options12 = new MarkerOptions();
        MarkerOptions options13 = new MarkerOptions();
        MarkerOptions options14 = new MarkerOptions();
        MarkerOptions options15 = new MarkerOptions();
        options1.position(perrera1).title("Centro de Control Canino Dr. Alfonso A. Ellini de la Garza").snippet("Telefono: 01 55 5607 4093");
        options2.position(perrera2).title("Centro de Control Canino").snippet("Telefono: 01 55 2160 5439");
        options3.position(perrera3).title("Brigada de Vigilancia Animal").snippet("Telefono: 01 55 5208 9898");
        options4.position(perrera4).title("EsculCan").snippet("Telefono: 01 55 9197 4685");
        options5.position(perrera5).title("Protectora Nacional de Animales").snippet("Telefono: 01 55 5604 2482");
        options6.position(perrera6).title("CLÍNICA VETERINARIA Dr. Cotera" ).snippet("Teléfono: 01 55 5603 2641").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        options7.position(perrera7).title("Clínica Veterinaria Huellas").snippet("Teléfono: 01 55 5678 3675").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        options8.position(perrera8).title("Clinica Veterinaria Del Valle").snippet("Teléfono: 01 55 5536 2719").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        options9.position(perrera9).title("Servicio Medico Veterinario Integral").snippet("Teléfono: 01 55 5580 0569").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        options10.position(perrera10).title("Especialidades Veterinarias del Sur").snippet("Teléfono: 01 55 5604 0331").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        options11.position(perrera11).title("Petco Mixcoac").snippet("Teléfono: 01 55 5611 6970").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        options12.position(perrera12).title("Huellas Pet Shop").snippet("Teléfono: 01 55 6271 2259").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        options13.position(perrera13).title("4BF").snippet("Teléfono: 01 55 5530 9337").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        options14.position(perrera14).title("EL RINCON DE LOS PERRIJOS").snippet("Teléfono: 01 55 5546 2004").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        options15.position(perrera15).title("Xami || Accesorios para Mascotas").snippet("Teléfono: 01 55 3233 7021").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        map.addMarker(options1);
        map.addMarker(options2);
        map.addMarker(options3);
        map.addMarker(options4);
        map.addMarker(options5);
        map.addMarker(options6);
        map.addMarker(options7);
        map.addMarker(options8);
        map.addMarker(options9);
        map.addMarker(options10);
        map.addMarker(options11);
        map.addMarker(options12);
        map.addMarker(options13);
        map.addMarker(options14);
        map.addMarker(options15);
        map.moveCamera(CameraUpdateFactory.newLatLng(perrera1));

    }

}
