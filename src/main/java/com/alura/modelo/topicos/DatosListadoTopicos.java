package com.alura.modelo.topicos;

import com.alura.modelo.curso.Curso;
import com.alura.modelo.StatusTopico;
import com.alura.modelo.usuario.Autor;

import java.time.LocalDateTime;

public record DatosListadoTopicos(String titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico status, Autor autor, Curso curso){

    public DatosListadoTopicos(Topico topico) {
        this(topico.getTitulo(),topico.getMensaje(),topico.getfechaCreacion(),topico.getStatus(),topico.getAutor(), (Curso) topico.getCurso());
    }

}
