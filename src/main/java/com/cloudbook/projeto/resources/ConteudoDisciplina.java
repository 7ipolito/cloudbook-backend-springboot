package com.cloudbook.projeto.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudbook.projeto.domain.Disciplina;
import com.cloudbook.projeto.services.DisciplinaService;

@RestController
@RequestMapping(value="/conteudos")
public class ConteudoDisciplina {

	@Autowired
	private DisciplinaService service;
	
	@RequestMapping(value="/{id}",method =RequestMethod.GET)
	public ResponseEntity<Disciplina> find(@PathVariable Integer id) {
		Disciplina obj=service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
