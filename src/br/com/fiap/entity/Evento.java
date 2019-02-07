package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Evento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 589964226594474942L;

	private int id;
	
	private String descricao;
	
	private Date data;
	
	private String responsavel;
	
	private Set<Participante> participantes;
	
	public Evento() {
	}

	public Evento(String descricao, Date data, String responsavel, Set<Participante> participantes) {
		super();
		this.descricao = descricao;
		this.data = data;
		this.responsavel = responsavel;
		this.participantes = participantes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public Set<Participante> getParticipantes() {
		return participantes;
	}
	
	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}
	
}
