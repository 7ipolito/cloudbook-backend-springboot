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

import com.cloudbook.projeto.domain.Conteudo;
import com.cloudbook.projeto.domain.Disciplina;
import com.cloudbook.projeto.domain.dto.ConteudoDTO;
import com.cloudbook.projeto.domain.dto.DisciplinaDTO;
import com.cloudbook.projeto.services.ConteudoService;

@RestController
@RequestMapping(value="/conteudos")
public class ConteudoResource {

	@Autowired
	private ConteudoService service;
	
	@RequestMapping(value="/{id}",method =RequestMethod.GET)
	public ResponseEntity<Conteudo> find(@PathVariable Integer id) {
		Conteudo obj=service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Conteudo conteudo) {
		conteudo = service.insert(conteudo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conteudo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Conteudo disciplina, @PathVariable Integer id) {
		disciplina.setId(id);
		disciplina = service.update(disciplina);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ConteudoDTO>> findAll() {
		List<Conteudo> list = service.findAll();
		List<ConteudoDTO> listDto = list.stream().map(obj -> new ConteudoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ConteudoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "ordeyBy", defaultValue = "assunto") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Conteudo> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ConteudoDTO> listDto = list.map(obj -> new ConteudoDTO(obj));
		return ResponseEntity.ok().body(listDto);

	}
	
}
