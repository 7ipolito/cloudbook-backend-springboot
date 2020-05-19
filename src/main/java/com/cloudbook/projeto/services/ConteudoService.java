package com.cloudbook.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbook.projeto.domain.Conteudo;
import com.cloudbook.projeto.repositories.ConteudoRepository;
import com.cloudbook.projeto.services.exceptions.ObjectNotFoundException;

@Service
public class ConteudoService {

	@Autowired
	private ConteudoRepository repo;

	public Conteudo find(Integer id) {

		Optional<Conteudo> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Conteudo não encontrado! Id: " + id + ", Tipo: " + Conteudo.class.getName()));
	}
	
	

}
