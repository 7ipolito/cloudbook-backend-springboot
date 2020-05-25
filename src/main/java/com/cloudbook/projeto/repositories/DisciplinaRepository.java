package com.cloudbook.projeto.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cloudbook.projeto.domain.Disciplina;


@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer>{


	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Disciplina obj WHERE obj.repositorio.id = ?1")
	Page<Disciplina> search(List<Integer>id,  Pageable pageRequest);
}
