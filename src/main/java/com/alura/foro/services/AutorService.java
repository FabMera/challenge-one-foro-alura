package com.alura.foro.services;

import com.alura.foro.modelo.usuario.Autor;
import com.alura.foro.modelo.usuario.AutorMostrarDTO;

import java.util.List;
import java.util.Optional;

public interface AutorService {


    List<AutorMostrarDTO> findAllDto();

    AutorMostrarDTO findAutorById(Long id);

    Autor saveAutor(Autor autor);

    void removeAutorById(Long id);

    AutorMostrarDTO updateAutor(Long id, AutorMostrarDTO autorMostrarDTO);

}
