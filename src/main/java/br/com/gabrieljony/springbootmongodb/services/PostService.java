package br.com.gabrieljony.springbootmongodb.services;

import br.com.gabrieljony.springbootmongodb.domain.Post;
import br.com.gabrieljony.springbootmongodb.domain.User;
import br.com.gabrieljony.springbootmongodb.dto.UserDTO;
import br.com.gabrieljony.springbootmongodb.repository.PostRepository;
import br.com.gabrieljony.springbootmongodb.repository.UserRepository;
import br.com.gabrieljony.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> searchTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Long minDate, Long maxDate) {
//        mimDate...
//        maxDate...
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
