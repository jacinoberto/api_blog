package com.blog.application.controllers;

import com.blog.application.dtos.UsuarioRecordDTO;
import com.blog.application.models.UsuarioModel;
import com.blog.application.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/user/new")
    private ResponseEntity<UsuarioModel> create(@RequestBody UsuarioRecordDTO usuarioDTO){
        UsuarioModel usuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuario);

        return ResponseEntity.ok().body(usuario);
    }
}
