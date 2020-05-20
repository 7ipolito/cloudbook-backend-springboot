package com.cloudbook.projeto.domain.dto;

import java.io.Serializable;

import com.cloudbook.projeto.domain.Disciplina;

public class DisciplinaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public DisciplinaDTO() {
		
	}
	
	public DisciplinaDTO(Disciplina obj) {
	nome= obj.getNome();

	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	
}
