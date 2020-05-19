package com.cloudbook.projeto.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService service;
	
	@RequestMapping(value="/{id}",method =RequestMethod.GET)
	public ResponseEntity<Aluno> find(@PathVariable Integer id) {
		Aluno obj=service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	//Inserindo Aluno
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Aluno aluno){
		aluno = service.insert(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	@RequestMapping(value="/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Aluno aluno,@PathVariable Integer id ){
		aluno.setId(id);
		aluno = service.update(aluno);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method =RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method =RequestMethod.GET)
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> list =service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
}
