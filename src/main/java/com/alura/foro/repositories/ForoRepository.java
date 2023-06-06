package com.alura.foro.repositories;

import com.alura.foro.modelo.topicos.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForoRepository extends JpaRepository<Topico, Long> {
}
