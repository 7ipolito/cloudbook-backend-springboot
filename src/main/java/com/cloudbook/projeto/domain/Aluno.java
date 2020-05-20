package com.cloudbook.projeto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String email;
	private String telefone;
	private String genero;
	private String colegio;

	@JsonIgnore
	@OneToMany(mappedBy = "aluno", cascade =CascadeType.ALL)
	List<Repositorio> repositorios = new ArrayList<>();
	
	public Aluno() {

	}

	public Aluno(Integer id,String nome, String email, String telefone, String genero, String colegio) {
		super();
		this.id=id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.genero = genero;
		this.colegio = colegio;
	}
	
	//FAVOR APAGAR DEPOIS
	public Aluno(Integer id,String nome) {
		super();
		this.id=id;
		this.nome = nome;
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
	
	

	public List<Repositorio> getRepositorios() {
		return repositorios;
	}

	public void setRepositorios(List<Repositorio> repositorios) {
		this.repositorios = repositorios;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}