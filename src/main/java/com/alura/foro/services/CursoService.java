package com.alura.foro.services;

import com.alura.foro.modelo.curso.Curso;
import com.alura.foro.modelo.usuario.Autor;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> findAllCursos();
    Optional<Curso> findCursoById(Long id);
    Curso saveCurso(Curso curso);
    void removeCursoById(Long id);
    Optional<Curso> updateCurso(Curso curso, Long id);
}
