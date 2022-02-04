package br.com.linecomp.springbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.linecomp.springbootmongodb.domain.Post;
import br.com.linecomp.springbootmongodb.domain.User;
import br.com.linecomp.springbootmongodb.dto.AuthorDTO;
import br.com.linecomp.springbootmongodb.repository.PostRepository;
import br.com.linecomp.springbootmongodb.repository.UserRepository;

@Configuration // anotacao para os spring entender que esta classe é de configuração
public class Instantiation implements CommandLineRunner { // necessário para executar os comandos no banco

	// injetar o nosso user repository para fazer operaçoes no DB

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll(); // para deletar todos os valores do mongodb e sempre adicionar estes
									// para evitar duplicatas

		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); // salvar todos no mongoDB

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		
		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
