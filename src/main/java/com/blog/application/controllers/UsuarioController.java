package com.blog.application.controllers;

import com.blog.application.dtos.UsuarioRecordDTO;
import com.blog.application.models.UsuarioModel;
import com.blog.application.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/user/new")
    public ResponseEntity<UsuarioModel> create(@RequestBody @Valid UsuarioRecordDTO usuarioDTO){
        UsuarioModel usuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Optional<UsuarioModel>> findById(@PathVariable UUID id){
        Optional<UsuarioModel> usuarioModel =  usuarioRepository.findById(id);
        return ResponseEntity.ok().body(usuarioModel);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UsuarioModel>> findAll(){
        List<UsuarioModel> usuarioModelList = usuarioRepository.findAll();
        return ResponseEntity.ok().body(usuarioModelList);
    }

    @PutMapping("user/alter/{id}")
    public ResponseEntity<UsuarioModel> update(@RequestBody UsuarioRecordDTO usuarioDTO, @PathVariable @Valid UUID id){
        UsuarioModel entity = usuarioRepository.getReferenceById(id);
        entity.setNome(usuarioDTO.nome());
        entity.setSenha(usuarioDTO.senha());
        usuarioRepository.save(entity);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<UsuarioModel> delete(@PathVariable UUID id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
