package com.example.moniub;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static AppDatabase db;
    TextView txt;
    List<Usuario> usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bd").allowMainThreadQueries().build();

        txt = findViewById(R.id.lt);

        Usuario u = new Usuario();
        u.setMatricula("123");
        u.setSenha("123");

        db.userDao().insertUsuario(u);

        Log.e("LOG",u.toString());

        usuarios = db.userDao().getUsuarios();

        Log.e("LOG",usuarios.toString());

        String dados ="";
        for(Usuario user : usuarios){
            String numero = user.getMatricula();
            String senha = user.getSenha();
            dados += dados+"\n\n"+"Numero de Matricula : "+numero+"  senha: "+senha;

        }
        txt.setText(usuarios.toString());

        // chamando tela de registro assim q o app abre so pra testar
//        Intent intent = new Intent(this, RegisterActivity.class);
//        startActivity(intent);

    }
}
