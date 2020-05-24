package com.cloudbook.projeto.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.domain.dto.AlunoDTO;
import com.cloudbook.projeto.domain.dto.AlunoNewDTO;
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
	public ResponseEntity<Void> insert(@Valid @RequestBody AlunoNewDTO alunoDto){
		Aluno obj = service.fromDTO(alunoDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	@RequestMapping(value="/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AlunoDTO alunoDto,@PathVariable Integer id ){
		Aluno obj = service.fromDTO(alunoDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method =RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(method =RequestMethod.GET)
	public ResponseEntity<List<AlunoDTO>> findAll() {
		List<Aluno> list =service.findAll();
		List<AlunoDTO> listDto = list.stream().map(obj -> new AlunoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(value="/page",method =RequestMethod.GET)
	public ResponseEntity<Page<AlunoDTO>> findPage(
	@RequestParam(value="page", defaultValue = "0") Integer page,
	@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
	@RequestParam(value="ordeyBy", defaultValue = "nome") String orderBy,
	@RequestParam(value="direction", defaultValue = "ASC") String direction) {
		Page<Aluno> list =service.findPage(page,linesPerPage,orderBy,direction);
		Page<AlunoDTO> listDto = list.map(obj -> new AlunoDTO(obj));
		return ResponseEntity.ok().body(listDto);
		
	}
}
