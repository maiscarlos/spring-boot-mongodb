package br.com.linecomp.springbootmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.linecomp.springbootmongodb.domain.Post;
import br.com.linecomp.springbootmongodb.domain.User;
import br.com.linecomp.springbootmongodb.dto.UserDTO;
import br.com.linecomp.springbootmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired // injecao de dependencias para Userservice
	private UserService service;

	@RequestMapping(method = RequestMethod.GET) // ou @GetMapping
	public ResponseEntity<List<UserDTO>> findAll() { // para montar o body da requisição

//		User maria = new User("1", "Maria Brown", "maria@gmail.com"); /mock
//		User alex = new User("2", "Alex Green", "alex@gmail.com");

		List<User> list = service.findAll(); // mock new ArrayList<>();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // converte cada
		// objeto da lista para um dto

//		list.addAll(Arrays.asList(maria, alex)); //mock

		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) { // para transmitir esse id pro getmapping
		User obj = service.findById(id);

		return ResponseEntity.ok().body(new UserDTO(obj));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {

		User obj = service.fromDto(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {

		User obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) { // para transmitir esse id pro getmapping
		User obj = service.findById(id);

		return ResponseEntity.ok().body(obj.getPosts());
	}

}
