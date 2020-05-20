package com.cloudbook.projeto.services;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudbook.projeto.domain.Conteudo;
import com.cloudbook.projeto.domain.Disciplina;
import com.cloudbook.projeto.domain.Repositorio;
import com.cloudbook.projeto.domain.Conteudo;
import com.cloudbook.projeto.domain.dto.ConteudoDTO;
import com.cloudbook.projeto.repositories.ConteudoRepository;
import com.cloudbook.projeto.services.exceptions.ObjectNotFoundException;

@Service
public class ConteudoService {

	@Autowired
	private ConteudoRepository repo;

	public Conteudo find(Integer id) {

		Optional<Conteudo> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Conteudo não encontrado! Id: " + id + ", Tipo: " + Conteudo.class.getName()));
	}
	
	public Conteudo insert(Conteudo conteudo) {
		conteudo.setId(null);
		return repo.save(conteudo);
	}
	
	public Conteudo update(Conteudo conteudo) {
		find(conteudo.getId());
		return repo.save(conteudo);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Conteudo> findAll(){
		return repo.findAll();
	}
	
	public Page<Conteudo> findPage(Integer page, Integer linesPerPage,String orderBy,String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
		
	}
	
	

}
