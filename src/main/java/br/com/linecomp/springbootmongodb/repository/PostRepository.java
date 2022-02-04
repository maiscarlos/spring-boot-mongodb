package br.com.linecomp.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.linecomp.springbootmongodb.domain.Post;

//acesso a bancos
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}