package com.example.musica;

import com.example.ItemCultural;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="musicas")
public class Musica extends ItemCultural {

    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private int duracao;  // em segundos

    public Musica() {
        super();
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
