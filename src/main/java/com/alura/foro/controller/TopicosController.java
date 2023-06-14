package com.alura.foro.controller;

import com.alura.foro.modelo.topicos.DTO.ListadoTopicosDTO;
import com.alura.foro.modelo.topicos.DTO.UpdateTopicosDTO;
import com.alura.foro.services.TopicServiceJPA;
import com.alura.foro.modelo.topicos.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicServiceJPA topicServiceJPA;

    public TopicosController(TopicServiceJPA topicServiceJPA) {
        this.topicServiceJPA = topicServiceJPA;
    }

    //Metodo para mostrar todos los topicos
    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        return ResponseEntity.ok(topicServiceJPA.findAll());
    }

    //Metodo para mostrar un topico por id
    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarTopicoPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicServiceJPA.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(topico.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    //Metodo para crear un topico
    //BindingResult es una clase que nos permite validar los campos del objeto que se esta enviando
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity crearTopico(@RequestBody @Valid Topico topico, BindingResult binding) {
        if (binding.hasErrors()) {
            return ResponseEntity.badRequest().body(binding.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(topicServiceJPA.save(topico));
    }

    //Metodo para eliminar un topico por id
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        topicServiceJPA.removeById(id);
        return ResponseEntity.noContent().build();
    }

    //Metodo para actualizar un topico
    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico(@RequestBody UpdateTopicosDTO updateTopicosDTO, @PathVariable Long id) {
        return ResponseEntity.ok(topicServiceJPA.updateTopico(updateTopicosDTO, id));

    }
}
