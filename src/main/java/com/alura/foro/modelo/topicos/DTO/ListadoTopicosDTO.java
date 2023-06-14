package com.alura.foro.modelo.topicos.DTO;

import com.alura.foro.modelo.curso.Curso;
import com.alura.foro.modelo.topicos.StatusTopico;
import com.alura.foro.modelo.usuario.Autor;
import com.alura.foro.modelo.usuario.AutorMostrarDTO;

import java.time.LocalDateTime;

public class ListadoTopicosDTO {
    String titulo;
    String mensaje;
    LocalDateTime fechaCreacion;
    StatusTopico status;
    Autor autor;
    Curso curso;

    public ListadoTopicosDTO() {
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
