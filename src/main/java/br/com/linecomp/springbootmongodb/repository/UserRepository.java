package br.com.linecomp.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.linecomp.springbootmongodb.domain.User;

//acesso a bancos
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
