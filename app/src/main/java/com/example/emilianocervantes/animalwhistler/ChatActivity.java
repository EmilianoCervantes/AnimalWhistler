package com.example.emilianocervantes.animalwhistler;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Arrays;

public class ChatActivity extends Activity {

    private Button button;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ChildEventListener childEventListener;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;

    private final int LOGIN = 123;

    private EditText editText;
    private ListView listView;
    private ChatAdapter chatAdapter;
    private String name;

    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("messages");
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference().child("photos");

        listView = (ListView)findViewById(R.id.listView);
        chatAdapter = new ChatAdapter(this,R.layout.chat_layout, new ArrayList<ChatPojo>());
        listView.setAdapter(chatAdapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);

                startActivityForResult(Intent.createChooser(intent, "Elige una foto"), 3007);
            }
        });

        editText = (EditText)findViewById(R.id.mensajeChat);
        button = (Button)findViewById(R.id.enviarMensaje);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String miMessage = editText.getText().toString();

                ChatPojo chatPojo = new ChatPojo(name, null, miMessage);

                databaseReference.push().setValue(chatPojo);

                editText.setText("");
            }
        });
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        /*if(firebaseUser != null){
            //Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
            name = firebaseUser.getDisplayName();
            loadChats();
        } else {
            //Si no se logeo, se muestre la lista de logins
            //La lista de proveedores (osea, redes sociales, etc)
            clean();
        }*/

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if(firebaseUser != null){
                    //Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
                    name = firebaseUser.getDisplayName();
                    loadChats();
                } else {
                    //Si no se logeo, se muestre la lista de logins
                    //La lista de proveedores (osea, redes sociales, etc)
                    clean();
                    startActivityForResult(
                            AuthUI
                                    .getInstance()
                                    .createSignInIntentBuilder()
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build()
                                            )
                                    )
                                    .build(),
                            LOGIN
                    );
                }
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 3007 && resultCode == RESULT_OK){
            //Si selecciono una imagen, aqui se cacha
            Uri pic = data.getData();
            //Le digo que a la carpeta le agregare una imagen mas
            StorageReference str = storageReference.child(pic.getLastPathSegment());
            //validar si fue exitoso
            str.putFile(pic).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //Aqui dira los datos de esa imagen que subio
                    //La ruta de esa imagen ya en el servidor
                    //Lo unico malo es que no hay progress bar
                    //Es una asynchronous task
                    Uri uploaded = taskSnapshot.getDownloadUrl();
                    //Con esto ya puedo agregar a la DB la referencia en el chat
                    ChatPojo chatPojo = new ChatPojo(name, uploaded.toString(), null);
                    //Y lo subimos a la db
                    databaseReference.push().setValue(chatPojo);
                }
            });
        }
    }

    private void clean(){
        name = "";
        chatAdapter.clear();
        if (childEventListener != null) {
            databaseReference.removeEventListener(childEventListener);
            childEventListener = null;
        }
    }

    private void loadChats(){
        if (childEventListener == null) {
            //Firebase tiene un listener para los hijos o los objs en la base
            childEventListener = new ChildEventListener() {
                //datasnapshot es el cambio en la base
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    //ChatPojo.class lo mapea y nos da la referencia
                    //No hay que poner gets y sets
                    ChatPojo chatPojo = dataSnapshot.getValue(ChatPojo.class);
                    chatAdapter.add(chatPojo);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                //Mover en cuanto a orden
                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
            //Rederencia a la base de datos
            //Esta ultima linea es porque creamos el adapter pero no estaba escuchando nada
            databaseReference.addChildEventListener(childEventListener);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        firebaseAuth.removeAuthStateListener(authStateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (firebaseAuth != null) {
            firebaseAuth.addAuthStateListener(authStateListener);
        }
    }
}
