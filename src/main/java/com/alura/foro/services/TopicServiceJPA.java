package com.alura.foro.services;

import com.alura.foro.repositories.ForoRepository;
import com.alura.modelo.topicos.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceJPA implements TopicoService {

    @Autowired
    private ForoRepository topicoRepository;

    //Metodo para mostrar todos los topicos
    @Transactional(readOnly = true)
    @Override
    public List<Topico> findAll() {
        return topicoRepository.findAll();
    }

    //Metodo para mostrar un topico por id
    @Transactional(readOnly = true)
    @Override
    public Optional<Topico> findById(Long id) {
        return topicoRepository.findById(id);
    }


    @Transactional
    @Override
    public Topico save(Topico topico) {
        return topicoRepository.save(topico);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        topicoRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<Topico> update(Topico topico, Long id) {
        Optional<Topico> op = findById(id);
        Topico topicoOptional = null;
        if (op.isPresent()) {
            Topico topicoDB = op.orElseThrow();
            topicoDB.setTitulo(topico.getTitulo());
            topicoDB.setMensaje(topico.getMensaje());
        }
        return op.ofNullable(topicoOptional);
    }
}
