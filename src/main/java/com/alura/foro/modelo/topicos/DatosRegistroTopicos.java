package com.alura.foro.modelo.topicos;

import com.alura.foro.modelo.curso.Curso;
import com.alura.foro.modelo.usuario.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopicos(
        @NotBlank String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Autor autor,
        @NotNull
        Curso curso) {
}
