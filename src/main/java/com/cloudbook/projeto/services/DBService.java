package com.cloudbook.projeto.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.domain.Conteudo;
import com.cloudbook.projeto.domain.Disciplina;
import com.cloudbook.projeto.domain.Repositorio;
import com.cloudbook.projeto.domain.enums.Perfil;
import com.cloudbook.projeto.domain.enums.TipoConteudo;
import com.cloudbook.projeto.repositories.AlunoRepository;
import com.cloudbook.projeto.repositories.ConteudoRepository;
import com.cloudbook.projeto.repositories.DisciplinaRepository;
import com.cloudbook.projeto.repositories.RepositorioRepository;

@Service
public class DBService {
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private AlunoRepository alunorepository;
	@Autowired
	private RepositorioRepository repositoriorepository;
	@Autowired
	private DisciplinaRepository disciplinarepository;
	@Autowired
	private ConteudoRepository conteudorepository;

	public void instantiateTestDatabase() throws ParseException {
		// INSTANCIAÇÃO DE ALUNOS
		Aluno a1 = new Aluno(null, "Allan Hipolito", "allanhipolito@gmail.com", "212435384", "M", "Iserj",pe.encode("23062003"));
		
		Aluno a2 = new Aluno(null, "Flavio Winovski", "winovski@gmail.com", "213527382", "M", "CIEP",pe.encode("flavinho"));
		Aluno a3 = new Aluno(null, "Flávia Rafael", "FRafael@gmail.com", "213527382", "F", "Faetec",pe.encode("flavinha"));
		Aluno a4 = new Aluno(null, "Thiago Montenegro", "montenegro@gmail.com", "213527382", "M", "Iserj",pe.encode("montenegro2003"));
		Aluno a5 = new Aluno(null, "Raphael Cocao", "RCocao@gmail.com", "213527382", "M", "Iserj",pe.encode("cocaogostoso"));
		Aluno a6 = new Aluno(null, "Yuri Brabo", "Ybrabo@gmail.com", "213527382", "M", "Iserj",pe.encode("fini"));
		Aluno a7 = new Aluno(null, "Felipe G", "força@gmail.com", "213527382", "M", "Iserj",pe.encode("forcag"));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date data1 = sdf.parse("06/04/2020 12:32");
		Date data2 = sdf.parse("10/03/2020 11:32");
		Date data3 = sdf.parse("30/02/2020 14:32");

		// INSTANCIAÇÃO DE REPOSITORIOS
		Repositorio r1 = new Repositorio(null, "Repositório Escola", data1, "Repositório para escola", a1);
		Repositorio r2 = new Repositorio(null, "Repositório Escola", data2, "Repositório para escola", a2);
		Repositorio r3 = new Repositorio(null, "Repositório Inglês", data3, "Repositório para curso de inglês", a1);

		// ALUNO CONHECENDO REPOSITORIO
		a1.getRepositorios().addAll(Arrays.asList(r1, r3));
		a2.getRepositorios().addAll(Arrays.asList(r2));

		Disciplina d1 = new Disciplina(null, "Matématica", r1);
		Disciplina d2 = new Disciplina(null, "Portugûes", r1);
		Disciplina d3 = new Disciplina(null, "Física", r1);
		Disciplina d4 = new Disciplina(null, "Matématica", r2);
		Disciplina d5 = new Disciplina(null, "Biologia", r2);
		Disciplina d6 = new Disciplina(null, "Semantica", r3);

		// REPOSITORIO CONHECENDO DISCIPLINA
		r1.getDisciplinas().addAll(Arrays.asList(d1, d2, d3));
		r2.getDisciplinas().addAll(Arrays.asList(d4, d5));
		r3.getDisciplinas().addAll(Arrays.asList(d6));

		// DATAS AUTOMATICAS

		Date data4 = sdf.parse("01/04/2020 12:32");
		Date data5 = sdf.parse("02/03/2020 11:32");
		Date data6 = sdf.parse("06/03/2020 14:32");
		Date data7 = sdf.parse("20/05/2020 14:32");
		Date data8 = sdf.parse("28/02/2020 14:32");

		//INSTANCIAÇÃO DE CONTEÚDO
		Conteudo c1 = new Conteudo(null, "Matrizes", data4, TipoConteudo.IMAGEM, d4);
		Conteudo c2 = new Conteudo(null, "Matrizes", data4, TipoConteudo.ANOTACAO, d4);
		Conteudo c3 = new Conteudo(null, "Cordados", data5, TipoConteudo.AUDIO, d5);
		Conteudo c4 = new Conteudo(null, "Verbo To Be", data6, TipoConteudo.IMAGEM, d6);
		Conteudo c5 = new Conteudo(null, "Regência verbal", data7, TipoConteudo.VIDEO, d2);

		//ALLAN ADMINISTRADOR DA BRANCH
		a1.addPerfil(Perfil.ADMIN);
		
		alunorepository.saveAll(Arrays.asList(a2, a1, a3, a4, a5, a6, a7));
		repositoriorepository.saveAll(Arrays.asList(r1, r2, r3));
		disciplinarepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6));
		conteudorepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

	}
}
