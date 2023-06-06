package com.alura.foro.modelo.curso;

import com.alura.foro.modelo.Categorias;
import com.alura.foro.modelo.topicos.Topico;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private CursosNombre nombre;

	@Enumerated(EnumType.STRING)
	private Categorias categoria;

	//Relacion con topicos
	@ManyToMany(mappedBy = "curso")
	private List<Topico> topicos;

	public Curso(CursosNombre nombre, Categorias categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}
	public Curso() {

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
		Curso other = (Curso) obj;
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

	public CursosNombre getNombre() {
		return nombre;
	}

	public void setNombre(CursosNombre nombre) {
		this.nombre = nombre;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

}
