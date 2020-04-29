package br.com.gabrieljony.springbootmongodb.config;

import br.com.gabrieljony.springbootmongodb.domain.Post;
import br.com.gabrieljony.springbootmongodb.domain.User;
import br.com.gabrieljony.springbootmongodb.repository.PostRepository;
import br.com.gabrieljony.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post = new Post(null, System.currentTimeMillis(), "Partiu Viagem", "Descrição do post de partiu viagem.", maria);
        Post post2 = new Post(null, System.currentTimeMillis(), "Partiu Viagem", "Descrição do post de partiu viagem.", alex);
        Post post3 = new Post(null, System.currentTimeMillis(), "Partiu Viagem", "Descrição do post de partiu viagem.", bob);
        Post post4 = new Post(null, System.currentTimeMillis(), "Partiu Viagem", "Descrição do post de partiu viagem.", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post, post2, post3, post4));
    }
}
