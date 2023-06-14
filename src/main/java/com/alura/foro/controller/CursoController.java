package com.alura.foro.controller;

import com.alura.foro.modelo.curso.Curso;
import com.alura.foro.services.CursoServiceJPA;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoServiceJPA cursoServiceJPA;

    public CursoController(CursoServiceJPA cursoServiceJPA) {
        this.cursoServiceJPA = cursoServiceJPA;
    }
    //Metodo para listar todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos(){
        return ResponseEntity.ok(cursoServiceJPA.findAllCursos());
    }
    //Metodo para crear un curso
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearCurso(@RequestBody @Valid Curso curso, BindingResult binding){
        if(binding.hasErrors()){
            return validation(binding);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoServiceJPA.saveCurso(curso));
    }

    //Metodo para eliminar un curso.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable Long id){
        cursoServiceJPA.removeCursoById(id);
        return ResponseEntity.noContent().build();
    }

    //Metodo para validar Errores:
    private ResponseEntity<?> validation(BindingResult binding) {
        Map<String,String> errores = new HashMap<>();
        binding.getFieldErrors().forEach(error -> {
            errores.put(error.getField(),error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

}
