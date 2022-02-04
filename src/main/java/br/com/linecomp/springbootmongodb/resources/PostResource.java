package br.com.linecomp.springbootmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.linecomp.springbootmongodb.domain.Post;
import br.com.linecomp.springbootmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired // injecao de dependencias para Userservice
	private PostService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) { // para transmitir esse id pro getmapping
		Post obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

}
