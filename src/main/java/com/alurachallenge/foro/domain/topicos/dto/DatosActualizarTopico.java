package com.alurachallenge.foro.domain.topicos.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosActualizarTopico(

        @NotNull Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        String autor,
        String curso
) {
}
