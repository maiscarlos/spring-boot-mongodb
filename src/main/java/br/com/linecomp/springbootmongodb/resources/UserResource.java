package br.com.linecomp.springbootmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.linecomp.springbootmongodb.domain.User;
import br.com.linecomp.springbootmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired //injecao de dependencias para Userservice
	private UserService service;

	@RequestMapping(method = RequestMethod.GET) // ou @GetMapping
	public ResponseEntity<List<User>> findAll() { // para montar o body da requisição
		
		
		
//		User maria = new User("1", "Maria Brown", "maria@gmail.com"); /mock
//		User alex = new User("2", "Alex Green", "alex@gmail.com");

		List<User> list = service.findAll(); //mock new ArrayList<>();

//		list.addAll(Arrays.asList(maria, alex)); //mock

		return ResponseEntity.ok().body(list);

	}

}
