package com.blog.application.controllers;

import com.blog.application.dtos.PostRecordDTO;
import com.blog.application.models.PostModel;
import com.blog.application.repositories.PostRepository;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
