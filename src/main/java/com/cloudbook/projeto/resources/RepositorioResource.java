package com.cloudbook.projeto.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudbook.projeto.domain.Repositorio;
import com.cloudbook.projeto.services.RepositorioService;

@RestController
@RequestMapping(value="/repositorios")
public class RepositorioResource {

	@Autowired
	private RepositorioService service;
	@RequestMapping(value="/{id}",method =RequestMethod.GET)
	
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Repositorio obj=service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	
	}
}
