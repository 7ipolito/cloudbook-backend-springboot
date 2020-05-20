package com.cloudbook.projeto.domain.dto;

import java.io.Serializable;

import com.cloudbook.projeto.domain.Aluno;

public class AlunoDTO implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String telefone;
	private char genero;
	private String colegio;
	
	public AlunoDTO() {
	
	}
	
	public AlunoDTO(Aluno obj) {
		nome=obj.getNome();
		email = obj.getEmail();
		telefone = obj.getTelefone();
		genero = obj.getGenero();
		colegio=obj.getColegio();
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getColegio() {
		return colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}
	
	
	
}
