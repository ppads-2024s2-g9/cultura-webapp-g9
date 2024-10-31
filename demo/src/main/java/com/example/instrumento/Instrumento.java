package com.example.instrumento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Instrumento")
public class Instrumento {

	@Id @GeneratedValue
	private long id;

	private String nome;
	private String tipo;
		
	public Instrumento() {
		super();
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
	public String getTipo() {
		return tipo;
	}
	public void seTipo(String tipo) {
		this.tipo = tipo;
	}


}