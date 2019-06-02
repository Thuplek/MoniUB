package com.example.moniub;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdpterUsuario extends BaseAdapter {
    private final List<Usuario> usuarios;
    private final Activity act;

    public AdpterUsuario(List<Usuario> cursos, Activity act) {
        this.usuarios = cursos;
        this.act = act;
    }
    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater()
                .inflate(R.layout.item_lista_user, parent, false);

        Usuario usuario = usuarios.get(position);

        TextView nome = view.findViewById(R.id.nome);
        TextView numeroMatricula =  view.findViewById(R.id.numeroMatricula);
        TextView contato = (TextView)view.findViewById(R.id.contato);
        TextView curso = (TextView)view.findViewById(R.id.spinnerCurso);

        nome.setText(usuario.getNome());
        numeroMatricula.setText(usuario.getMatricula());
        contato.setText(usuario.getContato());
        curso.setText(usuario.getCurso());


        return view;
    }
}
