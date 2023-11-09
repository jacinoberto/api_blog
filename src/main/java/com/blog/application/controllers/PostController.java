package com.blog.application.controllers;

import com.blog.application.dtos.PostRecordDTO;
import com.blog.application.models.PostModel;
import com.blog.application.repositories.PostRepository;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping(value = "/post/new")
    public ResponseEntity<PostModel> insert(@RequestBody @Valid PostRecordDTO postDTO){
        PostModel post = new PostModel();
        post.setConselho(api());
        BeanUtils.copyProperties(postDTO, post);


        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(post));
    }
    
    @GetMapping("/posts")
    public ResponseEntity<List<PostModel>> getPost(){
    	List<PostModel> posts = postRepository.findAll();
    	
    	return ResponseEntity.ok().body(posts);
    }

    @DeleteMapping("post/{id}")
    public ResponseEntity<PostModel> deletePost(@PathVariable UUID id) {
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("update/product/{id}") //funcao atualizar
    public ResponseEntity<PostModel> updateProduct (@RequestBody @Valid PostRecordDTO ProductRecordDTO) {

        PostModel post = new PostModel();
        BeanUtils.copyProperties(ProductRecordDTO, post);

        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(post));
    }

    private String api(){
        String apiUrl = "https://api.adviceslip.com/advice";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);
        return response;
    }
}
