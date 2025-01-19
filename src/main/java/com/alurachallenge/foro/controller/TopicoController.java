package com.alurachallenge.foro.controller;


import com.alurachallenge.foro.domain.topicos.Topico;
import com.alurachallenge.foro.domain.topicos.dto.DatosActualizarTopico;
import com.alurachallenge.foro.domain.topicos.dto.DatosListadoTopicos;
import com.alurachallenge.foro.domain.topicos.dto.DatosRegistroTopico;
import com.alurachallenge.foro.domain.topicos.dto.DatosRespuestaTopico;
import com.alurachallenge.foro.domain.topicos.repository.TopicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;


    //MOSTRAR LISTADO DE TOPICOS
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoTopico(@PageableDefault(size=5)Pageable paginacion){
        return  ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopicos::new));

    }

    //MOSTRAR TOPICO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> topicoPorId(@PathVariable long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getAutor(), topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }


    //EDITAR TOPICO
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable long id,  @RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getAutor(), topico.getCurso()
        ));
    }


    //CREAR TOPICO
    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getAutor(), topico.getCurso()
        );
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    //ELIMINADO LOGICO DE TOPICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

















}
