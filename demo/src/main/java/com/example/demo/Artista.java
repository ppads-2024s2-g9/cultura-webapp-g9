package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
 public class Artista {
    @Id @GeneratedValue
	private long id;
    private String nome;
    private int anoNascimento;
    private String nomeArtistico;
    private String generoMusical;
    private String nacionalidade;

    public Artista() {
        super();
    }

    // Getters e Setters
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

    public int getanoNascimento() {
        return anoNascimento;
    }

    public void setanoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getnomeArtistico() {
        return nomeArtistico;
    }

    public void setnomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }

    public String getgeneroMusical() {
        return generoMusical;
    }

    public void setgeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}