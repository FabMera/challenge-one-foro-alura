package com.alura.foro.modelo.topicos;

import jakarta.validation.constraints.NotNull;

public record DatosUpdateTopicos(

        @NotNull
        Long id,
        String titulo,
        String mensaje) {
}


