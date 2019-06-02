package com.example.moniub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


public class EditUserActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    static AppDatabase db;
    Long id_user;
    Spinner curso;
    EditText nome,matricula,email,contato,periodo;
    RadioGroup radioGroup;
    Button salvar;
    Usuario user;
    Switch tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bd").allowMainThreadQueries().build();

        curso = findViewById(R.id.spinnerCurso);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cursos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        curso.setAdapter(adapter);
        curso.setOnItemSelectedListener(this);

        //Preencher campos com os dados do bd

        nome = findViewById(R.id.nome);
        matricula = findViewById(R.id.numeroMatricula);
        //EditText senha = findViewById(R.id.senha);
        email = findViewById(R.id.email);
        contato = findViewById(R.id.contato);
        radioGroup = findViewById(R.id.sexo);
        periodo = findViewById(R.id.periodo);
        salvar = findViewById(R.id.salvar);
        tipo = findViewById(R.id.tipo);


        id_user = LoginActivity.id_user;
        String matricula_user = LoginActivity.matricula_user;

        user = db.userDao().findUsuarioByMatricula(matricula_user);

        nome.setText(user.getNome());
        matricula.setText(user.getMatricula());
        periodo.setText(user.getPeriodo());
        //senha.setText(user.getSenha());
        email.setText(user.getEmail());
        contato.setText(user.getContato());
        curso.setSelection(adapter.getPosition(user.getCurso()));

        if(user.getTipo() == 2){
            tipo.setChecked(true);
        }
        String sexo = user.getSexo();
        if(sexo.equals("Masculino")){
            radioGroup.check(R.id.masculino);
        }else{
            radioGroup.check(R.id.feminino);
        }
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar(user);
            }
        });


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      //  String text = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void salvar(Usuario user){

      user.setNome(nome.getText().toString());
      user.setMatricula(matricula.getText().toString());
      user.setPeriodo(periodo.getText().toString());
      user.setEmail(email.getText().toString());
      user.setContato(contato.getText().toString());
      user.setCurso((String) curso.getSelectedItem());
      String usersexo =((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
      user.setSexo(usersexo);
      if(tipo.isChecked()){
          user.setTipo(2);
      }else{
          user.setTipo(1);
      }


        db.userDao().updateUsuario(user);
        Toast.makeText(getApplicationContext(),"Dados atualizados com Sucesso!",Toast.LENGTH_SHORT).show();
        finish();


    }
}
