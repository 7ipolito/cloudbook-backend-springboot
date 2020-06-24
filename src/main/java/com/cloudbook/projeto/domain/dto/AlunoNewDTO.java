package com.cloudbook.projeto.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.services.exceptions.ObjectNotFoundException;
import com.cloudbook.projeto.services.validation.AlunoInsert;

@AlunoInsert
public class AlunoNewDTO implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(max=80, message ="O tamanho máximo permitido é de 80 caracteres")
	private String nome;
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message="Email Inválido")
	private String email;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String telefone;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String genero;
	
	private String colegio;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	

	public AlunoNewDTO() {
	
	}
	
	public AlunoNewDTO(Aluno obj) {
		id = obj.getId();
		nome=obj.getNome();
		email = obj.getEmail();
		telefone = obj.getTelefone();
		genero = obj.getGenero();
		colegio=obj.getColegio();
		senha = obj.getSenha();
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getColegio() {
		return colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
