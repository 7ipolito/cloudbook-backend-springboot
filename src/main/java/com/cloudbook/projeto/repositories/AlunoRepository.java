package com.cloudbook.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudbook.projeto.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
