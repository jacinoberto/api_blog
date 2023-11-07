package com.blog.application.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDTO(@NotBlank String nome, @NotBlank String senha) {
}
