package com.cloudbook.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.domain.Repositorio;

@Repository
public interface RepositorioRepository extends JpaRepository<Repositorio, Integer>{

}
