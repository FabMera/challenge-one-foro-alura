package com.alura.foro.modelo.topicos.DTO;

public class UpdateTopicosDTO {

    Long id;
    String titulo;
    String mensaje;

    public UpdateTopicosDTO() {
    }

    public UpdateTopicosDTO(Long id, String titulo, String mensaje) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}


