package com.cloudbook.projeto;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.domain.Conteudo;
import com.cloudbook.projeto.domain.Disciplina;
import com.cloudbook.projeto.domain.Repositorio;
import com.cloudbook.projeto.domain.enums.TipoConteudo;
import com.cloudbook.projeto.repositories.AlunoRepository;
import com.cloudbook.projeto.repositories.ConteudoRepository;
import com.cloudbook.projeto.repositories.DisciplinaRepository;
import com.cloudbook.projeto.repositories.RepositorioRepository;

@SpringBootApplication

public class CloubookApplication implements CommandLineRunner{

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CloubookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	
		
	}

}
