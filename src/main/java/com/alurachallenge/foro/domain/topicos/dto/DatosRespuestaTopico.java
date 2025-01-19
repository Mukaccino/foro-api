package com.alurachallenge.foro.domain.topicos.dto;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        String autor,
        String curso

) {
}
