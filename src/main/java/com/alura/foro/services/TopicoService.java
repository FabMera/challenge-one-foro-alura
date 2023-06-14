package com.alura.foro.services;

import com.alura.foro.modelo.topicos.DTO.ListadoTopicosDTO;
import com.alura.foro.modelo.topicos.DTO.UpdateTopicosDTO;
import com.alura.foro.modelo.topicos.Topico;

import java.util.List;
import java.util.Optional;

public interface TopicoService {

    List<Topico> findAll();

    Optional<Topico> findById(Long id);

    Topico save(Topico topico);

    void removeById(Long id);

    UpdateTopicosDTO updateTopico(UpdateTopicosDTO updateTopico, Long id);

}
