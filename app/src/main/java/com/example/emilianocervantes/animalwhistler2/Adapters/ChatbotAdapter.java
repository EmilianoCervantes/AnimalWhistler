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

import com.example.emilianocervantes.animalwhistler2.Models.ChatbotPojo;
import com.example.emilianocervantes.animalwhistler2.R;

import java.util.List;

/**
 * Created by Alfredo on 17/04/2018.
 */

public class ChatbotAdapter extends ArrayAdapter<ChatbotPojo> {
    public ChatbotAdapter(@NonNull Context context, int resource, @NonNull List<ChatbotPojo> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ChatbotPojo chatbotPojo = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mensaje_chat_layout, parent, false);
        }

        TextView titulo = (TextView)convertView.findViewById(R.id.nombreMensaje);
        TextView texto = (TextView)convertView.findViewById(R.id.textoMensaje);
        titulo.setText(chatbotPojo.getName().toString());
        texto.setText(chatbotPojo.getMessage().toString());
        ImageView imagen = (ImageView)convertView.findViewById(R.id.imageMensaje);
        if(chatbotPojo.getTipo() == 1){
            imagen.setImageResource(R.drawable.user);
        }else{
            imagen.setImageResource(R.drawable.robot);
        }

        return convertView;
    }
}
