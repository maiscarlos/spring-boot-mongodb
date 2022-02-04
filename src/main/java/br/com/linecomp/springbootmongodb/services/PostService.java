package br.com.linecomp.springbootmongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.linecomp.springbootmongodb.domain.Post;
import br.com.linecomp.springbootmongodb.repository.PostRepository;
import br.com.linecomp.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // automaticamente instancia um objeto userrepository (injecao de dependencia
				// automatica do spring)
	private PostRepository repo;

	public Post findById(String id) {

		Optional<Post> obj = repo.findById(id); // obrigatorio objeto Optional de User
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id " + id + " não encontrado"));
		// retorna o objeto ou lanca a excecao...
	}

	public List<Post> findByTitle(String text) {
//		return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);

		return repo.fullSearch(text, minDate, maxDate);

	}

}
