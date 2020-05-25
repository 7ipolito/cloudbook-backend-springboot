package com.cloudbook.projeto.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudbook.projeto.domain.Conteudo;


@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Integer>{


	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Conteudo obj WHERE obj.disciplina.id = ?1")
	Page<Conteudo> search(List<Integer>id,  Pageable pageRequest);
}
