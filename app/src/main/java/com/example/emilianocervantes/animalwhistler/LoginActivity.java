package com.example.emilianocervantes.animalwhistler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {

    private EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
    }

    public void entrar(View view){

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
        finish();
    }
}
