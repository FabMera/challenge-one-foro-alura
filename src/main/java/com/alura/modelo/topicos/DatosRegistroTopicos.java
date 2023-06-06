package com.alura.modelo.topicos;

import com.alura.modelo.curso.Curso;
import com.alura.modelo.usuario.Autor;
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
