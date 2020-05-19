package com.cloudbook.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbook.projeto.domain.Disciplina;
import com.cloudbook.projeto.repositories.DisciplinaRepository;
import com.cloudbook.projeto.services.exceptions.ObjectNotFoundException;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repo;

	public Disciplina find(Integer id) {

		Optional<Disciplina> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Disciplina não encontrado! Id: " + id + ", Tipo: " + Disciplina.class.getName()));
	}
	
	

}
