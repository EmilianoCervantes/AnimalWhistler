package com.example.emilianocervantes.animalwhistler2.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emilianocervantes.animalwhistler2.Models.MascotaPerdidaPojo;
import com.example.emilianocervantes.animalwhistler2.R;

import java.util.List;

/**
 * Created by Alfredo on 09/04/2018.
 */

public class MascotaPerdidaAdapter extends ArrayAdapter<MascotaPerdidaPojo> {
    public MascotaPerdidaAdapter(@NonNull Context context, int resource, @NonNull List<MascotaPerdidaPojo> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MascotaPerdidaPojo mascota = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mascota_perdida_layout, parent, false);
        }

        ImageView imagen = (ImageView)convertView.findViewById(R.id.image);
        TextView nombre = (TextView)convertView.findViewById(R.id.name);
        TextView tipo = (TextView)convertView.findViewById(R.id.type);
        TextView raza = (TextView)convertView.findViewById(R.id.breed);
        TextView color = (TextView)convertView.findViewById(R.id.color);
        TextView ubicacion = (TextView)convertView.findViewById(R.id.location);
        TextView descripcion = (TextView)convertView.findViewById(R.id.description);

        nombre.setText(mascota.getNombre());
        tipo.setText(mascota.getTipo());
        raza.setText(mascota.getRaza());
        color.setText(mascota.getColor());
        ubicacion.setText(mascota.getLugar());
        descripcion.setText(mascota.getDescripcion());
        if(mascota.getTipo().equalsIgnoreCase("perro")){
            imagen.setImageResource(R.drawable.perro);
        }
        if(mascota.getTipo().equalsIgnoreCase("gato")){
            imagen.setImageResource(R.drawable.gato);
        }

        return convertView;
    }
}
