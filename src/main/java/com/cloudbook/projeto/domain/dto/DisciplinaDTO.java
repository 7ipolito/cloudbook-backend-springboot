package com.cloudbook.projeto.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.cloudbook.projeto.domain.Disciplina;
import com.cloudbook.projeto.domain.Repositorio;

public class DisciplinaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(max=80, message ="O tamanho máximo permitido é de 80 caracteres")
	private String nome;

	
	
	public DisciplinaDTO() {
		
	}
	
	public DisciplinaDTO(Disciplina obj) {
	id = obj.getId();
	nome= obj.getNome();

	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}
	

	
}
