package com.alura.foro.controller;

import com.alura.foro.modelo.topicos.Topico;
import com.alura.foro.modelo.usuario.Autor;
import com.alura.foro.modelo.usuario.AutorMostrarDTO;
import com.alura.foro.services.AutorServiceJPA;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorServiceJPA autorServiceJPA;

    //Metodo para listar todos los autores con DTO y ModelMapper sin mostrar su Contraseña.
    @GetMapping()
    public ResponseEntity<List<AutorMostrarDTO>> listarDto() {
        return ResponseEntity.ok(autorServiceJPA.findAllDto());
    }

    //Metodo para listar autores por ID sin mostrar su Contraseña.
    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarAutorPorId(@PathVariable Long id) {
      return ResponseEntity.ok(autorServiceJPA.findAutorById(id));
    }

    //Metodo para crear un autor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearAutor(@RequestBody @Valid Autor autor, BindingResult binding) {
        if (binding.hasErrors()) {
            return ResponseEntity.badRequest().body(binding.getAllErrors());
        }
        return ResponseEntity.ok(autorServiceJPA.saveAutor(autor));
    }

    //Metodo para eliminar un autor
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarAutor(@PathVariable Long id) {
        autorServiceJPA.removeAutorById(id);
        return ResponseEntity.noContent().build();
    }

    //Metodo para actualizar un autor con DTO y ModelMapper
    @PutMapping("/{id}")
    public AutorMostrarDTO actualizarAutor(@PathVariable Long id, @RequestBody AutorMostrarDTO autorMostrarDTO) {
        return autorServiceJPA.updateAutor(id, autorMostrarDTO);
    }

}
