package com.example.moniub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ListView listaPeriodos = (ListView) findViewById(R.id.listaPeriodos);
        ArrayList<String> peridos = preencherPeridos();
        ArrayAdapter<String> periodosAdpter = new ArrayAdapter<String>(
                this, android.R.layout.simple_expandable_list_item_1, peridos);
        listaPeriodos.setAdapter(periodosAdpter);
    }

    private ArrayList<String> preencherPeridos() {
        ArrayList<String> periodos = new ArrayList<String>();
        periodos.add("1º Período");
        periodos.add("2º Período");
        periodos.add("3º Período");
        periodos.add("4º Período");
        periodos.add("5º Período");
        periodos.add("6º Período");
        periodos.add("7º Período");
        periodos.add("8º Período");
        return periodos;
    }
}
