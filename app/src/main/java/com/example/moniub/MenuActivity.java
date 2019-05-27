package com.example.moniub;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void telaprincipal(View v) {
        Intent intent = new Intent(this,PrincipalActivity.class);
        startActivity(intent);
    }
    public void telaeditar(View v) {
        //Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
       // startActivity(intent);
        Toast.makeText(getApplicationContext(),"Em Breve",Toast.LENGTH_SHORT).show();

    }
    public void telamonitor(View v) {
        //Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        // startActivity(intent);
        Toast.makeText(getApplicationContext(),"Em Breve",Toast.LENGTH_SHORT).show();
    }
    public void sair(){
        finishAffinity();
    }

}