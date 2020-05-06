package com.cloudbook.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.repositories.AlunoRepository;
import com.cloudbook.projeto.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
		public Aluno find(Integer id) {
			
			 Optional<Aluno> obj = repo.findById(id);
			 
			 return obj.orElseThrow(() -> new ObjectNotFoundException(
					 "Aluno não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName())); 
			} 

	}

