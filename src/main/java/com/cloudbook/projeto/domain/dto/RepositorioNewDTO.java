package com.cloudbook.projeto.domain.dto;

import java.io.Serializable;
import java.util.Date;

import com.cloudbook.projeto.domain.Aluno;

public class RepositorioNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Date data;
	private String descricao;
	

	private Aluno aluno= new Aluno();
	
	public RepositorioNewDTO() {
	
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	
	
	
}
