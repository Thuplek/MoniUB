package com.example.moniub;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    static AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "dadosUsuario").allowMainThreadQueries().build();
        // chamando tela de registro assim q o app abre so pra testar
//        Intent intent = new Intent(this, RegisterActivity.class);
//        startActivity(intent);

    }
}
