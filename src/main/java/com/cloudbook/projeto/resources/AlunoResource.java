package com.cloudbook.projeto.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudbook.projeto.domain.Aluno;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {

	@RequestMapping(method =RequestMethod.GET)
	public List<Aluno> listar() {
		
		Aluno a1 = new Aluno(1,"Allan");
		
		List<Aluno> lista = new ArrayList<>();
		lista.add(a1);
		
		return lista;
		
	
	}
}
