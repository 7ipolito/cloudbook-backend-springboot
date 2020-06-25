package com.cloudbook.projeto.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.cloudbook.projeto.domain.Repositorio;

@Repository
public interface RepositorioRepository extends JpaRepository<Repositorio, Integer>{

	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Repositorio obj WHERE obj.aluno.id = ?1")
	Page<Repositorio> search(List<Integer>id,  Pageable pageRequest);
}

	


	
	

