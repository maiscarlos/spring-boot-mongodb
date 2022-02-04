package br.com.linecomp.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.linecomp.springbootmongodb.domain.User;
import br.com.linecomp.springbootmongodb.dto.UserDTO;
import br.com.linecomp.springbootmongodb.repository.UserRepository;
import br.com.linecomp.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired // automaticamente instancia um objeto userrepository (injecao de dependencia
				// automatica do spring)
	private UserRepository repo;

	public List<User> findAll() { // metodo para retornar uma lista de usuarios do banco
		return repo.findAll();
	}

	public User findById(String id) {

		Optional<User> obj = repo.findById(id); // obrigatorio objeto Optional de User
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id " + id + " não encontrado"));
		// retorna o objeto ou lanca a excecao...
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());

	}

	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
