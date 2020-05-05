package com.cloudbook.projeto;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.domain.Repositorio;
import com.cloudbook.projeto.repositories.AlunoRepository;
import com.cloudbook.projeto.repositories.RepositorioRepository;

@SpringBootApplication
public class CloubookApplication implements CommandLineRunner{

	@Autowired
	private AlunoRepository alunorepository;
	@Autowired
	private RepositorioRepository repositoriorepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CloubookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ALUNOS
		Aluno a1 = new Aluno(null,"Allan Hipolito","allanhipolito@gmail.com","212435384",'M',"Iserj");
		Aluno a2 = new Aluno(null,"Flavio Winovski","winovski@gmail.com","213527382",'M',"CIEP");
		
		//REPOSITORIOS
		Repositorio r1 = new Repositorio(null,"Repositório Escola","Repositório para escola",false,a1);
		Repositorio r2 = new Repositorio(null,"Repositório Escola","Repositório para escola",false,a2);
		Repositorio r3 = new Repositorio(null,"Repositório Inglês","Repositório para curso de inglês",false,a1);
		
		
		
		
		alunorepository.saveAll(Arrays.asList(a1,a2));
		repositoriorepository.saveAll(Arrays.asList(r1,r2,r3));
		
	}

}
