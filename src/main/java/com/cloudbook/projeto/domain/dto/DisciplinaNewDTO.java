package com.cloudbook.projeto.domain.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cloudbook.projeto.domain.Repositorio;

public class DisciplinaNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	@NotNull
	private Repositorio repositorio = new Repositorio();
	public DisciplinaNewDTO() {
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Repositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}

	
	
}
