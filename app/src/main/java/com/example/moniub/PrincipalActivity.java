package com.example.moniub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity {
    public static final String CHAVE = "CHAVE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ListView listaPeriodos = (ListView) findViewById(R.id.listaPeriodos);
        final ArrayList<String> peridos = preencherPeridos();
        ArrayAdapter<String> periodosAdpter = new ArrayAdapter<String>(
                this, android.R.layout.simple_expandable_list_item_1, peridos);
        listaPeriodos.setAdapter(periodosAdpter);

        listaPeriodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String periodoSelecionado = peridos.get(position).toString();
                Intent i = new Intent(PrincipalActivity.this, TelaMateriasPeriodo.class);
                i.putExtra(CHAVE, periodoSelecionado);
                startActivity(i);

//            Toast.makeText(getApplicationContext(), "Período: "+ peridos.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
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
