package com.alura.foro.services;

import com.alura.modelo.topicos.Topico;

import java.util.List;
import java.util.Optional;

public interface TopicoService {

    List<Topico> findAll();
    Optional<Topico> findById(Long id);
    Topico save(Topico topico);
    void removeById(Long id);
    Optional<Topico> update(Topico topico, Long id);

}
