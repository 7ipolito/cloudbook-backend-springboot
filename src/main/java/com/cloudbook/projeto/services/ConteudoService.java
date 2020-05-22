package com.cloudbook.projeto.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cloudbook.projeto.domain.Conteudo;
import com.cloudbook.projeto.domain.Disciplina;
import com.cloudbook.projeto.domain.Repositorio;
import com.cloudbook.projeto.domain.dto.ConteudoDTO;
import com.cloudbook.projeto.domain.dto.ConteudoNewDTO;
import com.cloudbook.projeto.domain.enums.TipoConteudo;
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
		Conteudo newobj = find(conteudo.getId());
		updateData(newobj, conteudo);
		return repo.save(newobj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

	public List<Conteudo> findAll() {
		return repo.findAll();
	}

	public Page<Conteudo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);

	}

	public Conteudo fromDTO(ConteudoDTO objDto) {

		return new Conteudo(objDto.getId(), objDto.getAssunto(), objDto.getData_criacao(), objDto.getTipo(), null);
	}
	
	public Conteudo fromDTO(ConteudoNewDTO objDto) {
																								
		Conteudo conteudo= new Conteudo(null,objDto.getAssunto(),objDto.getData_criacao(),objDto.getTipo(),objDto.getDisciplina());
		
		return conteudo;
	
	}

	private void updateData(Conteudo newobj, Conteudo obj) {
		newobj.setAssunto(obj.getAssunto());
		newobj.setData_criacao(obj.getData_criacao());
		newobj.setTipo(obj.getTipo());
		

	}

}
