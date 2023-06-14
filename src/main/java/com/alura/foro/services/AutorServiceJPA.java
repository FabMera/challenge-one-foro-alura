package com.alura.foro.services;

import com.alura.foro.modelo.usuario.Autor;
import com.alura.foro.modelo.usuario.AutorMostrarDTO;
import com.alura.foro.repositories.AutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorServiceJPA implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public List<AutorMostrarDTO> findAllDto() {
        List<Autor> autores = autorRepository.findAll();
        return autores.stream()
                .map(autor -> modelMapper
                        .map(autor, AutorMostrarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AutorMostrarDTO findAutorById(Long id) {
        Optional<Autor> op = autorRepository.findAutorById(id);
        if (op.isPresent()) {
            Autor autor = op.get();
            return modelMapper.map(autor, AutorMostrarDTO.class);
        }
        throw new NoSuchElementException("No existe el autor con id: " + id);
    }

    @Override
    @Transactional
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void removeAutorById(Long id) {
        autorRepository.deleteById(id);
    }

    @Override
    public AutorMostrarDTO updateAutor(Long id, AutorMostrarDTO autorMostrarDTO) {
        Optional<Autor> usuarioOptional = autorRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Autor autor = usuarioOptional.get();
            autor.setNombre(autorMostrarDTO.getNombre());
            autor.setEmail(autorMostrarDTO.getEmail());

            Autor autorUpdate = autorRepository.save(autor);
            return modelMapper.map(autorUpdate, AutorMostrarDTO.class);
        }
        throw new NoSuchElementException("No existe el autor con id: " + id);
    }

}
