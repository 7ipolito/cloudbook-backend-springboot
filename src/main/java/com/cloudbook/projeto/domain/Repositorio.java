package com.cloudbook.projeto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Repositorio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Date data;
	private String descricao;
	private boolean visibilidade;
	
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno = new Aluno();
	
	public Repositorio() {
	
	}

	public Repositorio(Integer id,String nome, Date data, String descricao, boolean visibilidade, Aluno aluno) {
		super();
		this.id=id;
		this.nome = nome;
		this.data = data;
		this.descricao = descricao;
		this.visibilidade = visibilidade;
		this.aluno = aluno;
	}
	
//APAGAR DEPOIS
	public Repositorio(Integer id,String nome, String descricao, boolean visibilidade, Aluno aluno) {
		super();
		this.id=id;
		this.nome = nome;
		this.descricao = descricao;
		this.visibilidade = visibilidade;
		this.aluno = aluno;
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

	public boolean isVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repositorio other = (Repositorio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
