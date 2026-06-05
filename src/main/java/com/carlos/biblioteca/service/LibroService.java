package com.carlos.biblioteca.service;

import com.carlos.biblioteca.model.Libro;
import com.carlos.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //  le dice a Spring que esta clase es la capa de lógica de negocio y la gestiona automáticamente
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }

    public List<Libro> buscarPorAutor(String autor) {
    return libroRepository.findByAutorContainingIgnoreCase(autor);
    }

    public List<Libro> buscarPorTitulo(String titulo) {
    return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }
}