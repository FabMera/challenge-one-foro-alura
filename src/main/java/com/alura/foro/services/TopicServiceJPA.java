package com.alura.foro.services;

import com.alura.foro.modelo.topicos.DTO.UpdateTopicosDTO;
import com.alura.foro.repositories.ForoRepository;
import com.alura.foro.modelo.topicos.Topico;
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

    //Metodo para crear un topico
    @Transactional
    @Override
    public Topico save(Topico topico) {
        return topicoRepository.save(topico);
    }

    //Metodo para eliminar un topico por id

    @Override
    @Transactional
    public void removeById(Long id) {
        topicoRepository.deleteById(id);
    }

    //Metodo para actualizar un topico
    @Transactional
    @Override
    public UpdateTopicosDTO updateTopico(UpdateTopicosDTO updateTopicosDTO, Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow();
        topico.setTitulo(updateTopicosDTO.getTitulo());
        topico.setMensaje(updateTopicosDTO.getMensaje());
        topicoRepository.save(topico);
        return updateTopicosDTO;
    }

}
