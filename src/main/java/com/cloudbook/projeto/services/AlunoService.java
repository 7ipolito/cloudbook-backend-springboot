package com.cloudbook.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.domain.dto.AlunoDTO;
import com.cloudbook.projeto.domain.dto.AlunoNewDTO;
import com.cloudbook.projeto.domain.enums.Perfil;
import com.cloudbook.projeto.repositories.AlunoRepository;
import com.cloudbook.projeto.security.UserSS;
import com.cloudbook.projeto.services.exceptions.AuthorizationException;
import com.cloudbook.projeto.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private AlunoRepository repo;

	public Aluno find(Integer id) {

		UserSS user = UserService.authenticated();
		if(user ==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Aluno> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Aluno não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}
	
	public Aluno insert(Aluno aluno) {
		aluno.setId(null);
		return repo.save(aluno);
	}
	
	public Aluno update(Aluno aluno) {
		Aluno newobj =find(aluno.getId());
		updateData(newobj,aluno);
		return repo.save(newobj);
		
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Aluno> findAll(){
		return repo.findAll();
	}

	public Page<Aluno> findPage(Integer page, Integer linesPerPage,String orderBy,String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
		
	}
	
	public Aluno fromDTO(AlunoDTO objDto) {
		
		return new Aluno(objDto.getId(),objDto.getNome(),
		objDto.getEmail(),objDto.getTelefone(),objDto.getGenero(),objDto.getColegio(),null);
	}
	
public Aluno fromDTO(AlunoNewDTO objDto) {
		
		return new Aluno(objDto.getId(),objDto.getNome(),
		objDto.getEmail(),objDto.getTelefone(),objDto.getGenero(),objDto.getColegio(),pe.encode(objDto.getSenha()));
	}
	
	private void updateData(Aluno newobj,Aluno obj) {
		newobj.setNome(obj.getNome());
		newobj.setEmail(obj.getEmail());
		newobj.setGenero(obj.getGenero());
		newobj.setTelefone(obj.getTelefone());
		newobj.setColegio(obj.getColegio());

		
	}
}
