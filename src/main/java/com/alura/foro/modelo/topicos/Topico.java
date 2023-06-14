package com.alura.foro.modelo.topicos;

import com.alura.foro.modelo.curso.Curso;
import com.alura.foro.modelo.respuesta.Respuesta;
import com.alura.foro.modelo.topicos.DTO.UpdateTopicosDTO;
import com.alura.foro.modelo.usuario.Autor;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topicos")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;

	//Relacion con autor
	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;

	//Relacion con cursos
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;

	//Relacion con respuestas
	@OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
	private List<Respuesta> respuestas;

	public Topico(String titulo, String mensaje, Autor autor, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.autor = autor;
		this.curso = curso;
	}
	public Topico() {
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

/*
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
*/

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}

