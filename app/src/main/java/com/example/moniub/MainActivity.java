package com.example.moniub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        // chamando tela de registro assim q o app abre so pra testar
//        Intent intent = new Intent(this, RegisterActivity.class);
//        startActivity(intent);

    }
}
