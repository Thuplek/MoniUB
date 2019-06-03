package com.example.moniub;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UsuarioDAO {
    @Query("SELECT * FROM usuario")
    LiveData<List<Usuario>> getUsuarios();

    @Query("SELECT * FROM usuario WHERE id IN (:UsuarioIds)")
    List<Usuario> loadAllByIds(int[] UsuarioIds);

    @Query("SELECT * FROM usuario WHERE nome LIKE :nome")
    Usuario findName(String nome);

    @Query("SELECT * FROM usuario WHERE matricula LIKE :matricula")
    Usuario findUsuarioByMatricula(String matricula);

    @Query("SELECT * FROM usuario WHERE id LIKE :matricula")
    Usuario findUsuarioById(String matricula);

    @Query("DELETE FROM usuario WHERE matricula LIKE :matricula")
    int removeUser(String matricula);

    @Update
    public void updateUsuario(Usuario usuario);

    @Insert
    void insertUsuario(Usuario... Usuarios);

    @Delete
    void delete(Usuario Usuario);
}