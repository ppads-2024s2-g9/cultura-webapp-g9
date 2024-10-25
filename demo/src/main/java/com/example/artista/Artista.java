package com.example.artista;

import com.example.ItemCultural;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="artistas")
public class Artista extends ItemCultural {

    private String nome;
    private String anoNasc;
    private String nacionalidade;

    public Artista() {
        super();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAnoNasc() {
        return anoNasc;
    }
    public void setAnoNasc(String anoNasc) {
        this.anoNasc = anoNasc;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
