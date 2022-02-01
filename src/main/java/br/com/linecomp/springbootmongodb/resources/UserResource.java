package br.com.linecomp.springbootmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.linecomp.springbootmongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET) // ou @GetMapping
	public ResponseEntity<List<User>> findAll() { // para montar o body da requisição
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");

		List<User> list = new ArrayList<>();

		list.addAll(Arrays.asList(maria, alex));

		return ResponseEntity.ok().body(list);

	}

}
