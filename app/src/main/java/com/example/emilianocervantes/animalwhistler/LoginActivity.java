package com.example.emilianocervantes.animalwhistler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

    private EditText user, password;
    private Button entrar, registrar;

    private final int REQUEST_CODE = 7007;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
    }

    public void entrar(View view){
        /*
        if(TextUtils.isEmpty(user.getText())){
            user.setError("Captura tu correo");
            return;
        }
        if(TextUtils.isEmpty(password.getText())){
            password.setError("Captura tu contraseña");
            return;
        }

        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();*/
    }

    public void registrarUser(View view){
        Intent intent = new Intent(this,RegistroActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
}
