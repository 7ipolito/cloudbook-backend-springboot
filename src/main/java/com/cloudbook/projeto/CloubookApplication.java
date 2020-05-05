package com.cloudbook.projeto;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.repositories.AlunoRepository;

@SpringBootApplication
public class CloubookApplication implements CommandLineRunner{

	@Autowired
	private AlunoRepository alunorepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CloubookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Aluno a1 = new Aluno(null,"Allan Hipolito","allanhipolito@gmail.com","212435384",'M',"Iserj");
		Aluno a2 = new Aluno(null,"Flavio Winovski","winovski@gmail.com","213527382",'M',"CIEP");
		
		alunorepository.saveAll(Arrays.asList(a1,a2));
		
	}

}
