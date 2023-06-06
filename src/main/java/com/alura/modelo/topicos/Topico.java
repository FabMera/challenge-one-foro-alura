package com.alura.modelo.topicos;

import com.alura.modelo.curso.Curso;
import com.alura.modelo.respuesta.Respuesta;
import com.alura.modelo.StatusTopico;
import com.alura.modelo.usuario.Autor;
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
	private LocalDateTime fechaCreacion;
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;

	//Relacion con autor
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	//Relacion con cursos
	@ManyToMany
	@JoinTable(name = "topico_curso",
			joinColumns = @JoinColumn(name = "id_topico"),
			inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> curso;

	//Relacion con respuestas
	@OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
	private List<Respuesta> respuestas;

	public Topico(DatosRegistroTopicos datosRegistroTopicos) {
		this.titulo = datosRegistroTopicos.titulo();
		this.mensaje = datosRegistroTopicos.mensaje();
		this.fechaCreacion = LocalDateTime.now();
	}

	public Topico() {

	}
	public void actualizarTopico(DatosUpdateTopicos datosUpdateTopicos) {
		if(datosUpdateTopicos.titulo() != null) {
			this.titulo = datosUpdateTopicos.titulo();
		}
		if(datosUpdateTopicos.mensaje() != null) {
			this.mensaje = datosUpdateTopicos.mensaje();
		}

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

	public LocalDateTime getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(LocalDateTime fechaCreacion) {
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

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

}
