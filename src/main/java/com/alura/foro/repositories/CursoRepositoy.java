package com.alura.foro.repositories;

import com.alura.foro.modelo.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositoy extends JpaRepository<Curso, Long> {
}
