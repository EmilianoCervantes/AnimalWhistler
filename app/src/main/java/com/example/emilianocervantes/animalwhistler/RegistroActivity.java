package com.example.emilianocervantes.animalwhistler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroActivity extends Activity {

    private Button registrar, regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registrar = (Button)findViewById(R.id.botonRegistrate);
        regresar = (Button)findViewById(R.id.botonYaRegistrado);
    }

    public void UsuarioYaRegistrado(View view){
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
