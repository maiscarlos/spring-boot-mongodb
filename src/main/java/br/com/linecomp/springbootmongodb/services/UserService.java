package br.com.linecomp.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.linecomp.springbootmongodb.domain.User;
import br.com.linecomp.springbootmongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired //automaticamente instancia um objeto userrepository (injecao de dependencia automatica do spring)
	private UserRepository repo;
	
	public List<User> findAll(){ //metodo para retornar uma lista de usuarios do banco
		return repo.findAll();
	}
}
