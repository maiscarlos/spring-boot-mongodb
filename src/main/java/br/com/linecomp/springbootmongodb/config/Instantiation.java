package br.com.linecomp.springbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.linecomp.springbootmongodb.domain.User;
import br.com.linecomp.springbootmongodb.repository.UserRepository;

@Configuration // anotacao para os spring entender que esta classe é de configuração
public class Instantiation implements CommandLineRunner { // necessário para executar os comandos no banco

	// injetar o nosso user repository para fazer operaçoes no DB

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll(); // para deletar todos os valores do mongodb e sempre adicionar estes
									// para evitar duplicatas

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));  //salvar todos no mongoDB

	}

}
