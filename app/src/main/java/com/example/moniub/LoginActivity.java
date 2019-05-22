package com.example.moniub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    Button cadastrar;
    EditText matricula;
    EditText senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void entrar(View v) {
        matricula = findViewById(R.id.numeroMatricula);
        String sMatricula = matricula.getText().toString();
        senha = findViewById(R.id.senha);
        String sSenha = senha.getText().toString();
        if(sMatricula.equals("12345") && sSenha.equals("12345")){
            Intent intent = new Intent(LoginActivity.this, TelaMateriasPeriodo.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Credenciais incorretas",Toast.LENGTH_SHORT).show();
        }






    }

    public void telaregister(View v) {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }



}
