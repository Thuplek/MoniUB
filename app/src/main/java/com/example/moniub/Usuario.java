package com.example.moniub;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "periodo")
    private String periodo;
    @ColumnInfo(name = "senha")
    private String senha;
    @ColumnInfo(name = "matricula")
    private String matricula;
    @ColumnInfo(name = "curso")
    private String curso;

    public Usuario(String nome, String periodo, String senha, String matricula, String curso) {
        this.nome = nome;
        this.periodo = periodo;
        this.senha = senha;
        this.matricula = matricula;
        this.curso = curso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}