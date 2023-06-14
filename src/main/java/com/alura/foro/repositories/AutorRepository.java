package com.alura.foro.repositories;

import com.alura.foro.modelo.usuario.Autor;
import com.alura.foro.modelo.usuario.AutorMostrarDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findAutorById(Long id);

}
