package com.cloudbook.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbook.projeto.domain.Repositorio;
import com.cloudbook.projeto.repositories.RepositorioRepository;
import com.cloudbook.projeto.services.exceptions.ObjectNotFoundException;

@Service
public class RepositorioService {
	
	@Autowired
	private RepositorioRepository repo;
	
		public Repositorio find(Integer id) {
			
			 Optional<Repositorio> obj = repo.findById(id);
			 
			 return obj.orElseThrow(() -> new ObjectNotFoundException(
					 "Repositorio não encontrado! Id: " + id + ", Tipo: " + Repositorio.class.getName())); 
			} 

	}

