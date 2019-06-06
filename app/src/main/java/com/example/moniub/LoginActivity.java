package com.example.moniub;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    Button cadastrar;
    Button entrar;
    static Long id_user;
    static String matricula_user;

    static AppDatabase db;

//    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        entrar = (Button) findViewById(R.id.entrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar(v);
            }
        });
    }

    public void entrar(View v) {

        EditText matricula  = findViewById(R.id.numeroMatricula);
        EditText senha =  findViewById(R.id.senha);

        String sMatricula = matricula.getText().toString();
        String sSenha = senha.getText().toString();

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bd").allowMainThreadQueries().build();
        Usuario user = db.userDao().findUsuarioByMatricula(sMatricula);
        String SENHA = "";
        if(user != null){
            SENHA = user.getSenha();
            if(sSenha.equals(SENHA)) {
                Toast.makeText(getApplicationContext(),"Credenciais Corretas",Toast.LENGTH_SHORT).show();
                id_user = user.getId();
                matricula_user = user.getMatricula();

                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();

            }else {
                Toast.makeText(getApplicationContext(),"Credenciais incorretas",Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(),"Usuário não cadastrado!",Toast.LENGTH_SHORT).show();
        }

    }

    public void telaregister(View v) {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

}
