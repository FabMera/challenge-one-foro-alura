package com.alura.foro.repositories;

import com.alura.modelo.topicos.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForoRepository extends JpaRepository<Topico, Long> {
}
