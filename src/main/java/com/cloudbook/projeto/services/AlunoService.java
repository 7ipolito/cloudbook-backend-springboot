package com.cloudbook.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	
		public Aluno find(Integer id) {
			
			 Optional<Aluno> obj = repo.findById(id);
			return obj.orElse(null);
			} 

	}

