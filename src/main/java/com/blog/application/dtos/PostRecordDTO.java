package com.blog.application.dtos;

import jakarta.validation.constraints.NotBlank;

public record PostRecordDTO(@NotBlank String titulo, @NotBlank String post){
}
