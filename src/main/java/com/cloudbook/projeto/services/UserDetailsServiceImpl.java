package com.cloudbook.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cloudbook.projeto.domain.Aluno;
import com.cloudbook.projeto.repositories.AlunoRepository;
import com.cloudbook.projeto.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AlunoRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Aluno aluno = repo.findByEmail(email);
		if (aluno == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(aluno.getId(), aluno.getEmail(), aluno.getSenha(), aluno.getPerfis());
	}

}
