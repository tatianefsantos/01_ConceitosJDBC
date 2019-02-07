package br.com.fiap.entity;

import java.io.Serializable;

public class Participante implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5456897001743119682L;

	private int id;
	
	private int idEvento;
	
	private String nome;
	
	private String email;
	
	public Participante() {
	}

	public Participante(int id, int idEvento, String nome, String email) {
		super();
		this.id = id;
		this.idEvento = idEvento;
		this.nome = nome;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
