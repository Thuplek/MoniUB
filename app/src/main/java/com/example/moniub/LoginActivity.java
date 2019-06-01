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
    EditText matricula;
    EditText senha;

    static AppDatabase db;
//    public static final String MyPREFERENCES = "MyPrefs";
    public static final String MATRICULA = "1";
//    public static String SENHA;

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
//        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public void entrar(View v) {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bd").allowMainThreadQueries().build();

        matricula  = (EditText) findViewById(R.id.numeroMatricula);
        senha = (EditText) findViewById(R.id.senha);
        String sMatricula = matricula.getText().toString();
        String sSenha = senha.getText().toString();

        Usuario user = db.userDao().findUsuarioByMatricula(sMatricula);
        String SENHA = user.getSenha();

        if(sSenha.equals(SENHA)) {
            Toast.makeText(getApplicationContext(),"Credenciais Corretas",Toast.LENGTH_SHORT).show();

//            SharedPreferences.Editor editor = sharedpreferences.edit();
//            editor.putString(MATRICULA, sMatricula);
//            editor.putString(SENHA, sSenha);
//            editor.commit();

            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(intent);

        }else {
            Toast.makeText(getApplicationContext(),"Credenciais incorretas",Toast.LENGTH_SHORT).show();
        }
    }

    public void telaregister(View v) {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

}
