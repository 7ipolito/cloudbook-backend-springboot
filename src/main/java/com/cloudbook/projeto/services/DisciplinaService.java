package com.cloudbook.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cloudbook.projeto.domain.Disciplina;
import com.cloudbook.projeto.domain.dto.DisciplinaDTO;
import com.cloudbook.projeto.domain.dto.DisciplinaNewDTO;
import com.cloudbook.projeto.repositories.DisciplinaRepository;
import com.cloudbook.projeto.services.exceptions.ObjectNotFoundException;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repo;

	public Disciplina find(Integer id) {

		Optional<Disciplina> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Disciplina não encontrado! Id: " + id + ", Tipo: " + Disciplina.class.getName()));
	}
	
	public Disciplina insert(Disciplina disciplina) {
		disciplina.setId(null);
		return repo.save(disciplina);
	}
	
	public Disciplina update(Disciplina disciplina) {
		Disciplina newobj =find(disciplina.getId());
		updateData(newobj,disciplina);
		return repo.save(newobj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Disciplina> findAll(){
		return repo.findAll();
	}
	
	public Page<Disciplina> findPage(Integer page, Integer linesPerPage,String orderBy,String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
		
	}
	
	public Disciplina fromDTO(DisciplinaDTO objDto) {
		
		return new Disciplina(objDto.getId(),objDto.getNome(),null);
	}
	
	public Disciplina fromDTO(DisciplinaNewDTO objDto) {
		
		
		Disciplina disciplina = new Disciplina (null,objDto.getNome(),objDto.getRepositorio());	
		
		
		return disciplina;
	}
	private void updateData(Disciplina newobj,Disciplina obj) {
		newobj.setNome(obj.getNome());
	
		
	}

}
