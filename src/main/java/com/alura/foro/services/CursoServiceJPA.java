package com.alura.foro.services;

import com.alura.foro.modelo.curso.Curso;
import com.alura.foro.repositories.CursoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceJPA implements CursoService {

    @Autowired
    private CursoRepositoy cursoRepositoy;
    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAllCursos() {
        return (List<Curso>) cursoRepositoy.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findCursoById(Long id) {
        return cursoRepositoy.findById(id);
    }

    @Override
    @Transactional
    public Curso saveCurso(Curso curso) {
        return cursoRepositoy.save(curso);
    }

    @Override
    @Transactional
    public void removeCursoById(Long id) {
        cursoRepositoy.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Curso> updateCurso(Curso curso, Long id) {
        Optional<Curso> op = findCursoById(id);
        Curso cursoOptional = null;
        if(op.isPresent()){
            Curso cursoDB = op.orElseThrow();
            cursoDB.setNombre(curso.getNombre());
            cursoDB.setCategoria(curso.getCategoria());
            cursoOptional = this.saveCurso(cursoDB);
        }
        return Optional.ofNullable(cursoOptional);
    }
}
