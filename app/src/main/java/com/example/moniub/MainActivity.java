package com.example.moniub;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static AppDatabase db;
    static AdpterUsuario adapter;
    TextView txt;
    ListView listausuario;
    List<Usuario> usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bd").allowMainThreadQueries().build();

        usuarios = new ArrayList<>();

        listausuario = findViewById(R.id.lista);
        listausuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        LiveData<List<Usuario>> liveData =  db.userDao().getUsuarios();
        liveData.observe(this, new Observer<List<Usuario>>() {
            @Override
            public void onChanged(@Nullable List<Usuario> usuarios ) {
                atualizarUsuario(usuarios);
            }
        });
        // chamando tela de registro assim q o app abre so pra testar
//        Intent intent = new Intent(this, RegisterActivity.class);
//        startActivity(intent);

    }
    public void atualizarUsuario(List<Usuario> usuarios) {
        AdpterUsuario adapter = new AdpterUsuario(usuarios, this);
        listausuario.setAdapter(adapter);
    }

}

