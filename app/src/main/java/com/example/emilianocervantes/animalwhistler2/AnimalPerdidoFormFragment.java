package com.example.emilianocervantes.animalwhistler2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.emilianocervantes.animalwhistler2.Models.MascotaPerdidaPojo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalPerdidoFormFragment extends Fragment {

    private EditText nombre, lugar, descripcion;
    private Button enviar;

    private Spinner tipoAnimal, raza, color;
    private String animalSeleccionado, razaSeleccionada, colorSeleccionado;

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

        tipoAnimal = (Spinner)view.findViewById(R.id.campoTipo);
        raza = (Spinner)view.findViewById(R.id.campoRaza);
        color = (Spinner)view.findViewById(R.id.campoColor);

        lugar = (EditText)view.findViewById(R.id.campoLugar);
        descripcion = (EditText)view.findViewById(R.id.campoDescripcion);
        enviar = (Button)view.findViewById(R.id.botonForm);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("animalesperdidos");

        final String[] animales = {"Perro", "Gato"};
        //, , , , , , , , , , , , , , ,
        final String[] razasPerro = {
                "Akita", "Beagle", "Border Collie", "Boxer", "Bulldog", "Bull Terrier", "Chihuhua", "Cocker", "Doberman", "Golden",
                "Husky", "Labrador", "Maltese", "Pastor Alemán", "Pastor Inglés", "Pitbull", "Pointer", "Pug", "Rottweiler", "San Bernardo",
                "Schnauzer", "Shih Tzu", "Yorkshire","Abisino", "American Shorthair", "Bengala", "Bobtail", "British", "Burmés", "Cornish Rex", "Dragon Li", "Exótico", "Himalayo",
                "Main Coon", "Nebelung", "Noruego", "Ocicat", "Persa", "Peterbald", "Ragdoll", "Sagrado de Birmania", "Savannah", "Scottish Fold",
                "Siamés", "Siberiano", "Sphynx", "Tonkinés"
        };
        final String[] razasGato = {
                "Abisino", "American Shorthair", "Bengala", "Bobtail", "British", "Burmés", "Cornish Rex", "Dragon Li", "Exótico", "Himalayo",
                "Main Coon", "Nebelung", "Noruego", "Ocicat", "Persa", "Peterbald", "Ragdoll", "Sagrado de Birmania", "Savannah", "Scottish Fold",
                "Siamés", "Siberiano", "Sphynx", "Tonkinés"
        };
        final String[] colores = {
                "Amarillento", "Amarronado", "Anaranjado", "Azulado", "Blanquecino", "Café", "Grisáceo",
                "Magenta", "Negruzco", "Rojizo", "Rosado", "Verdoso", "Verduzco", "Violáceo"
        };

        ArrayAdapter<String> adapterColor = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, colores);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                colorSeleccionado = colores[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        color.setAdapter(adapterColor);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animales);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, animales);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoAnimal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                animalSeleccionado = animales[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //
            }
        });
        tipoAnimal.setAdapter(adapter);

        ArrayAdapter<String> adapterAnimales;
        adapterAnimales = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1, razasPerro);
        adapterAnimales.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raza.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (animalSeleccionado.equalsIgnoreCase("Perro")){
                    razaSeleccionada = razasPerro[i];
                } else {
                    razaSeleccionada = razasGato[i];
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        raza.setAdapter(adapterAnimales);



        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MascotaPerdidaPojo animal = new MascotaPerdidaPojo();
                if(TextUtils.isEmpty(nombre.getText())){
                    nombre.setError("Si no tiene un nombre pon 'No se encontró'.");
                    return;
                }
                if(TextUtils.isEmpty(descripcion.getText())){
                    descripcion.setError("Anexa detalles particulares de la mascota, su estado y cosas que te parezcan relevantes.");
                    return;
                }
                animal.setNombre(nombre.getText().toString());
                //animal.setTipo(tipoAnimal.getText().toString());
                animal.setTipo(animalSeleccionado);
                //animal.setRaza(raza.getText().toString());
                animal.setRaza(razaSeleccionada);
                //animal.setColor(color.getText().toString());
                animal.setColor(colorSeleccionado);
                animal.setLugar(lugar.getText().toString());
                animal.setDescripcion(descripcion.getText().toString());

                databaseReference.push().setValue(animal);

                nombre.setText("");
                //tipoAnimal.setText("");
                //raza.setText("");
                //color.setText("");
                lugar.setText("");
                descripcion.setText("");

                Toast.makeText(getActivity(), "Haz reportado un animal perdido exitosamente",Toast.LENGTH_LONG).show();
            }
        });
    }
}
