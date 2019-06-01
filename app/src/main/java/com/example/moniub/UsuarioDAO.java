package com.example.moniub;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsuarioDAO {
    @Query("SELECT * FROM usuario")
    List<Usuario> getUsuarios();

    @Query("SELECT * FROM usuario WHERE id IN (:UsuarioIds)")
    List<Usuario> loadAllByIds(int[] UsuarioIds);

    @Query("SELECT * FROM usuario WHERE nome LIKE :nome")
    Usuario findName(String nome);

    @Insert
    void insertUsuario(Usuario... Usuarios);

    @Delete
    void delete(Usuario Usuario);
}