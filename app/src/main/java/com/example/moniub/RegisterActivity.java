package com.example.moniub;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button cadastrar;
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

        cadastrar = findViewById(R.id.cadastrar);



            spinner = findViewById(R.id.spinnerCursos);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.cursos, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);


            cadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cadastrar();
                }
            });


        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String text = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
        public void telalogin(View v){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }

        public void cadastrar(){
            EditText matricula = findViewById(R.id.numeroMatricula);
            EditText senha = findViewById(R.id.senha);
            EditText email = findViewById(R.id.email);
            EditText contato = findViewById(R.id.contato);
            Spinner curso = findViewById(R.id.spinnerCursos);
            RadioGroup radioGroup = (RadioGroup)findViewById(R.id.sexo);

            String userMatricula = matricula.getText().toString();
            String userSenha = senha.getText().toString();
            String useremail = email.getText().toString();
            String usercontato = contato.getText().toString();
            Integer usercurso =  spinner.getSelectedItemPosition();
            String sexo =((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

            Usuario user = new Usuario();
            user.setMatricula(userMatricula);
            user.setSenha(userSenha);
            user.setEmail(useremail);
            user.setContato(useremail);
            user.setSexo(sexo);

            MainActivity.db.userDao().insertUsuario(user);
            Toast.makeText(getApplicationContext(),"Usuario Cadastrado com sucesso!",Toast.LENGTH_SHORT).show();
            finish();

        }

    }
