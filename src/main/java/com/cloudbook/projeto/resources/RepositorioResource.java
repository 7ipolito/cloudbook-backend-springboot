package com.cloudbook.projeto.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudbook.projeto.domain.Repositorio;
import com.cloudbook.projeto.domain.dto.RepositorioDTO;
import com.cloudbook.projeto.services.RepositorioService;

@RestController
@RequestMapping(value="/repositorios")
public class RepositorioResource {

	@Autowired
	private RepositorioService service;
	@RequestMapping(value="/{id}",method =RequestMethod.GET)
	
	public ResponseEntity<Repositorio> find(@PathVariable Integer id) {
		
		Repositorio obj=service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	
	}
	
	@RequestMapping(method =RequestMethod.GET)
	public ResponseEntity<List<RepositorioDTO>> findAll() {
		List<Repositorio> list =service.findAll();
		List<RepositorioDTO> listDto = list.stream().map(obj -> new RepositorioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
}
