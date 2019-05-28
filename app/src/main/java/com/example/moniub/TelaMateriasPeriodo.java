package com.example.moniub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaMateriasPeriodo extends AppCompatActivity {

    ArrayList<String> materiasPerido1SI = new ArrayList<>();
    ArrayList<String> materiasPerido2SI = new ArrayList<>();
    ArrayList<String> materiasPerido3SI = new ArrayList<>();
    ArrayList<String> materiasPerido4SI = new ArrayList<>();
    ArrayList<String> materiasPerido5SI = new ArrayList<>();
    ArrayList<String> materiasPerido6SI = new ArrayList<>();
    ArrayList<String> materiasPerido7SI = new ArrayList<>();
    ArrayList<String> materiasPerido8SI = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_materias_periodo);
        PreencherMaterias();

        ListView listaMaterias = (ListView) findViewById(R.id.listaMaterias);
        TextView textPeriodo = findViewById(R.id.textPeriodo);
        ArrayAdapter<String> materiasPeridoAdpter;

        Intent i = getIntent();
        String periodo = "";
        if(i.hasExtra(PrincipalActivity.CHAVE)){
            periodo = i.getStringExtra(PrincipalActivity.CHAVE);
        }

        textPeriodo.setText("Matérias do "+periodo);

        Toast.makeText(getApplicationContext(), periodo, Toast.LENGTH_SHORT).show();

        switch (periodo){
            case "1º Período":
                materiasPeridoAdpter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, materiasPerido1SI);
                listaMaterias.setAdapter(materiasPeridoAdpter);
                break;
            case "2º Período":
                materiasPeridoAdpter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, materiasPerido2SI);
                listaMaterias.setAdapter(materiasPeridoAdpter);
                break;
            case "3º Período":
                materiasPeridoAdpter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, materiasPerido3SI);
                listaMaterias.setAdapter(materiasPeridoAdpter);
                break;
            case "4º Período":
                materiasPeridoAdpter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, materiasPerido4SI);
                listaMaterias.setAdapter(materiasPeridoAdpter);
                break;
            case "5º Período":
                materiasPeridoAdpter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, materiasPerido5SI);
                listaMaterias.setAdapter(materiasPeridoAdpter);
                break;
            case "6º Período":
                materiasPeridoAdpter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, materiasPerido6SI);
                listaMaterias.setAdapter(materiasPeridoAdpter);
                break;
            case "7º Período":
                materiasPeridoAdpter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, materiasPerido7SI);
                listaMaterias.setAdapter(materiasPeridoAdpter);
                break;
            case "8º Período":
                materiasPeridoAdpter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, materiasPerido8SI);
                listaMaterias.setAdapter(materiasPeridoAdpter);
                break;
        }


    }

    private void PreencherMaterias() {

        materiasPerido1SI.add("FUNDAMENTOS DE INTERNET");
        materiasPerido1SI.add("FUNDAMENTOS DE SISTEMAS DE INFORMAÇÃO");
        materiasPerido1SI.add("INICIAÇÃO UNIVERSITÁRIA");
        materiasPerido1SI.add("INTEGRAÇÃO E SOCIALIZAÇÃO PESSOAL E PROFISSIONAL");
        materiasPerido1SI.add("INTRODUÇÃO À COMPUTAÇÃO");
        materiasPerido1SI.add("LÍNGUA PORTUGUESA");
        materiasPerido1SI.add("LÓGICA");

        materiasPerido2SI.add("ALGORITMOS E PROGRAMAÇÃO I");
        materiasPerido2SI.add("ARQUITETURA E ORGANIZAÇÃO DE COMPUTADORES");
        materiasPerido2SI.add("EMPREENDEDORISMO");
        materiasPerido2SI.add("INTEGRAÇÃO E SOCIALIZAÇÃO PESSOAL E PROFISSIONAL");
        materiasPerido2SI.add("MATEMATICA APLICADA");
        materiasPerido2SI.add("METODOLOGIA CIENTÍFICA");
        materiasPerido2SI.add("REDES DE COMPUTADORES");

        materiasPerido3SI.add("ADMINISTRAÇÃO E GERENCIA DE REDES");
        materiasPerido3SI.add("ALGORITMOS E PROGRAMAÇÃO II");
        materiasPerido3SI.add("BANCO DE DADOS I");
        materiasPerido3SI.add("COMPORTAMENTO ORGANIZACIONAL");
        materiasPerido3SI.add("FUNDAMENTOS DE ADMINISTRAÇÃO");
        materiasPerido3SI.add("INTEGRAÇÃO E SOCIALIZAÇÃO PESSOAL E PROFISSIONAL");
        materiasPerido3SI.add("SISTEMAS OPERACIONAIS");

        materiasPerido4SI.add("BANCO DE DADOS II");
        materiasPerido4SI.add("ENGENHARIA DE SOFTWARE I");
        materiasPerido4SI.add("ESTRUTURA DE DADOS I");
        materiasPerido4SI.add("FUNDAMENTOS DE CONTABILIDADE");
        materiasPerido4SI.add("INFORMATICA E SOCIEDADE");
        materiasPerido4SI.add("INTEGRAÇÃO E SOCIALIZAÇÃO PESSOAL E PROFISSIONAL");
        materiasPerido4SI.add("PROGRAMAÇÃO ORIENTADA A OBJETO");

        materiasPerido5SI.add("ENGENHARIA DE SOFTWARE II");
        materiasPerido5SI.add("ESTATÍSTICA");
        materiasPerido5SI.add("ESTRUTURA DE DADOS II");
        materiasPerido5SI.add("INTEGRAÇÃO E SOCIALIZAÇÃO PESSOAL E PROFISSIONAL");
        materiasPerido5SI.add("PARADIGMAS DE LINGUAGENS DE PROGRAMAÇÃO");
        materiasPerido5SI.add("PROGRAMAÇÃO VISUAL");
        materiasPerido5SI.add("TECNOLOGIA DE PROGRAMAÇÃO PARA DISPOSITIVOS MOVEIS");

        materiasPerido6SI.add("ANÁLISE DE ALGORITMOS E COMPUTABILIDADE");
        materiasPerido6SI.add("AUTOMAÇÃO PARA O AGRONEGÓCIO");
        materiasPerido6SI.add("GERENCIA DE PROJETOS DE SOFTWARE");
        materiasPerido6SI.add("INTEGRAÇÃO E SOCIALIZAÇÃO PESSOAL E PROFISSIONAL");
        materiasPerido6SI.add("PESQUISA OPERACIONAL");
        materiasPerido6SI.add("PRÁTICA PROFISSIONAL SUPERVISIONADA");
        materiasPerido6SI.add("TECNOLOGIA E PROGRAMAÇÃO WEB");

        materiasPerido7SI.add("ÉTICA EM COMPUTAÇÃO");
        materiasPerido7SI.add("INTEGRAÇÃO E SOCIALIZAÇÃO PESSOAL E PROFISSIONAL");
        materiasPerido7SI.add("INTELIGÊNCIA ARTIFICIAL");
        materiasPerido7SI.add("PROJETO DE TRABALHO DE CONCLUSÃO DE CURSO");
        materiasPerido7SI.add("SEGURANÇA E AUDITORIA DE SISTEMAS");
        materiasPerido7SI.add("SISTEMAS DISTRIBUÍDOS");
        materiasPerido7SI.add("TÓPICOS ESPECIAIS EM SISTEMAS DE INFORMAÇÃO");

        materiasPerido8SI.add("COMPUTAÇÃO GRÁFICA E PROCESSAMENTO DE IMAGEM");
        materiasPerido8SI.add("GOVERNANÇA EM TI");
        materiasPerido8SI.add("INTEGRAÇÃO E SOCIALIZAÇÃO PESSOAL E PROFISSIONAL");
        materiasPerido8SI.add("INTELIGÊNCIA DE NEGÓCIOS");
        materiasPerido8SI.add("OPTATIVA");
        materiasPerido8SI.add("TRABALHO DE CONCLUSÃO DE CURSO");

    }

}
