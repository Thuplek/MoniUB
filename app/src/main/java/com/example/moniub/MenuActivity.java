package com.example.moniub;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageView sair = findViewById(R.id.sair);
        ImageView monitor = findViewById(R.id.monitor);
        ImageView editar = findViewById(R.id.editar);


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

    }
    public void telaprincipal(View v) {
        Intent intent = new Intent(this,PrincipalActivity.class);
        startActivity(intent);
    }
    public void telaeditar(View v) {

        Toast.makeText(getApplicationContext(),"Em Breve",Toast.LENGTH_SHORT).show();

    }
    public void telamonitor(View v) {

        Toast.makeText(getApplicationContext(),"Em Breve",Toast.LENGTH_SHORT).show();
    }
    public void sair(){
        finish();
        moveTaskToBack(true);
    }

}