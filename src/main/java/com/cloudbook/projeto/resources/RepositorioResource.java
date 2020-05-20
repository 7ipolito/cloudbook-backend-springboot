package com.cloudbook.projeto.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudbook.projeto.domain.Repositorio;
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
	
	//Inserindo Repositorio
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody Repositorio repositorio){
			repositorio = service.insert(repositorio);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
					buildAndExpand(repositorio.getId()).toUri();
			return ResponseEntity.created(uri).build();
			
		}
		@RequestMapping(value="/{id}",method =RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody Repositorio repositorio,@PathVariable Integer id ){
			repositorio.setId(id);
			repositorio = service.update(repositorio);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(value="/{id}",method =RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Integer id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
	
	@RequestMapping(method =RequestMethod.GET)
	public ResponseEntity<List<RepositorioDTO>> findAll() {
		List<Repositorio> list =service.findAll();
		List<RepositorioDTO> listDto = list.stream().map(obj -> new RepositorioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(value="/page",method =RequestMethod.GET)
	public ResponseEntity<Page<RepositorioDTO>> findPage(
	@RequestParam(value="page", defaultValue = "0") Integer page,
	@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
	@RequestParam(value="ordeyBy", defaultValue = "nome") String orderBy,
	@RequestParam(value="direction", defaultValue = "ASC") String direction) {
		Page<Repositorio> list =service.findPage(page,linesPerPage,orderBy,direction);
		Page<RepositorioDTO> listDto = list.map(obj -> new RepositorioDTO(obj));
		return ResponseEntity.ok().body(listDto);
		
	}
}
