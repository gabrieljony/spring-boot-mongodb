package br.com.gabrieljony.springbootmongodb.controller;

import br.com.gabrieljony.springbootmongodb.controller.util.URL;
import br.com.gabrieljony.springbootmongodb.domain.Post;
import br.com.gabrieljony.springbootmongodb.domain.User;
import br.com.gabrieljony.springbootmongodb.dto.UserDTO;
import br.com.gabrieljony.springbootmongodb.services.PostService;
import br.com.gabrieljony.springbootmongodb.services.UserService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
        List<Post> list = postService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/searchtitle", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> searchTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.searchTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
