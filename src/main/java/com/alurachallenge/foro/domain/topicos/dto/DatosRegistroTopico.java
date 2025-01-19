package com.alurachallenge.foro.domain.topicos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        LocalDateTime fecha_creacion,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}
