package com.alura.foro.controller;


import com.alura.foro.services.TopicServiceJPA;
import com.alura.modelo.topicos.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicServiceJPA topicServiceJPA;

    @GetMapping
    public ResponseEntity<List<Topico>> listar(){
        return ResponseEntity.ok(topicServiceJPA.findAll());
    }
}
