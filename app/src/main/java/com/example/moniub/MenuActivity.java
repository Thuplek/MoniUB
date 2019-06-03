package com.example.moniub;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    Long id_user;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageView sair = findViewById(R.id.sair);
        ImageView monitor = findViewById(R.id.monitor);
        ImageView editar = findViewById(R.id.editar);

        TextView periodos = findViewById(R.id.periodos);
        TextView perfil = findViewById(R.id.perfil);
        TextView serMonitor = findViewById(R.id.serMonitor);
        TextView sairText = findViewById(R.id.sairText);

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sair();
            }
        });
        monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telamonitor(v);
            }
        });
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telaeditar(v);
            }
        });

        periodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telaprincipal(v);
            }
        });
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telaeditar(v);
            }
        });
        serMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telamonitor(v);
            }
        });
        sairText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sair();
            }
        });

    }
    public void telaprincipal(View v) {
        Intent intent = new Intent(this,PrincipalActivity.class);
        startActivity(intent);
    }
    public void telaeditar(View v) {

        Intent intent = new Intent(this,EditUserActivity.class);
        startActivity(intent);


    }
    public void telamonitor(View v) {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bd").allowMainThreadQueries().build();
        id_user = LoginActivity.id_user;

        Usuario user = db.userDao().findUsuarioById(id_user.toString());

        if(user.getTipo() == 2){
            Intent intent = new Intent(this,TornarMonitorActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Função liberada apenas para usuarios que são monitores",Toast.LENGTH_SHORT).show();
        }

    }
    public void sair(){
        finish();
        moveTaskToBack(true);
    }

}