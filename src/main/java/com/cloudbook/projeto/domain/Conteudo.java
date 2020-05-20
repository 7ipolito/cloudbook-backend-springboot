package com.cloudbook.projeto.domain;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.cloudbook.projeto.domain.enums.TipoConteudo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conteudo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String assunto;
	private Date data_criacao;
	private Integer tipo;

	
	@ManyToOne
	@JoinColumn(name="disciplina_id")
	private Disciplina disciplina = new Disciplina();

	public Conteudo(Integer id, String assunto, Date data_criacao, TipoConteudo tipo, Disciplina disciplina) {
		super();
		this.id = id;
		this.assunto = assunto;
		this.data_criacao = data_criacao;
		this.tipo = (tipo==null)?null:tipo.getCod();
		this.disciplina = disciplina;
	}
	
	public Conteudo() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisiplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public TipoConteudo getTipo() {
		return TipoConteudo.toEnum(tipo);
	}

	public void setTipo(TipoConteudo tipo) {
		this.tipo = tipo.getCod();
	}
	
	
	
	
	
}
