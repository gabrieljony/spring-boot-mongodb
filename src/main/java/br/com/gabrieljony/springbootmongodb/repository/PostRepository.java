package br.com.gabrieljony.springbootmongodb.repository;

import br.com.gabrieljony.springbootmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

//    https://docs.spring.io/spring-data/data-document/docs/current/reference/html/#repositories.query-methods
    List<Post> findByTitleContainingIgnoreCase(String text);
}
