package com.blog.application.controllers;

import com.blog.application.dtos.PostRecordDTO;
import com.blog.application.models.PostModel;
import com.blog.application.repositories.PostRepository;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping(value = "/post/new")
    public ResponseEntity<PostModel> insert(@RequestBody @Valid PostRecordDTO postDTO){
        PostModel post = new PostModel();
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


    @PutMapping("post/{id}")
    public ResponseEntity<PostModel> teste(@PathVariable UUID id) {
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }




}
