package com.cloudbook.projeto.domain.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.cloudbook.projeto.domain.Disciplina;
import com.cloudbook.projeto.domain.enums.TipoConteudo;

public class ConteudoNewDTO {
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String assunto;
	private Date data_criacao;
	private Integer tipo;
	
	private Disciplina disciplina = new Disciplina();

	public ConteudoNewDTO() {
	
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


	public TipoConteudo getTipo() {
		return TipoConteudo.toEnum(tipo);
	}

	public void setTipo(TipoConteudo tipo) {
		this.tipo = tipo.getCod();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	

}
