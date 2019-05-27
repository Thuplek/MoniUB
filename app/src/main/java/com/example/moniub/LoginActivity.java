package com.example.moniub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
//    public static final String MyPREFERENCES = "MyPrefs";
    public static final String MATRICULA = "1";
    public static final String SENHA = "1";

//    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public void entrar(View v) {

        matricula = findViewById(R.id.numeroMatricula);
        senha = findViewById(R.id.senha);

        String sMatricula = matricula.getText().toString();
        String sSenha = senha.getText().toString();

        if(sMatricula.equals(MATRICULA) && sSenha.equals(SENHA)){

//            SharedPreferences.Editor editor = sharedpreferences.edit();
//            editor.putString(MATRICULA, sMatricula);
//            editor.putString(SENHA, sSenha);
//            editor.commit();

            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
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
