package com.alurachallenge.foro.domain.topicos.dto;

import com.alurachallenge.foro.domain.topicos.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        String autor,
        String curso
) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(),
                topico.getMensaje(),topico.getFecha_creacion(),
                topico.getAutor(),topico.getCurso());
    }

}
