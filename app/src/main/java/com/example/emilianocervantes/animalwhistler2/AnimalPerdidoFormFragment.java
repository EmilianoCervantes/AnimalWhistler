package com.example.emilianocervantes.animalwhistler2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.emilianocervantes.animalwhistler2.Models.MascotaPerdidaPojo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalPerdidoFormFragment extends Fragment {

    private EditText nombre, tipo, raza, color, lugar, descripcion;
    private Button enviar;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    public AnimalPerdidoFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal_perdido_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombre = (EditText)view.findViewById(R.id.campoNombre);
        tipo = (EditText)view.findViewById(R.id.campoTipo);
        raza = (EditText)view.findViewById(R.id.campoRaza);
        color = (EditText)view.findViewById(R.id.campoColor);
        lugar = (EditText)view.findViewById(R.id.campoLugar);
        descripcion = (EditText)view.findViewById(R.id.campoDescripcion);
        enviar = (Button)view.findViewById(R.id.botonForm);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("animalesperdidos");

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MascotaPerdidaPojo animal = new MascotaPerdidaPojo();
                animal.setNombre(nombre.getText().toString());
                animal.setTipo(tipo.getText().toString());
                animal.setRaza(raza.getText().toString());
                animal.setColor(color.getText().toString());
                animal.setLugar(lugar.getText().toString());
                animal.setDescripcion(descripcion.getText().toString());

                databaseReference.push().setValue(animal);

                nombre.setText("");
                tipo.setText("");
                raza.setText("");
                color.setText("");
                lugar.setText("");
                descripcion.setText("");

                Toast.makeText(getActivity(), "Haz reportado un animal perdido exitosamente",Toast.LENGTH_LONG).show();
            }
        });
    }
}
