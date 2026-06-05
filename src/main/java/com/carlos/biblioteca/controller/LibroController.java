package com.carlos.biblioteca.controller;

import com.carlos.biblioteca.model.Libro;
import com.carlos.biblioteca.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController // combina dos cosas: que esta clase es un Controller y que las respuestas se devuelven automáticamente en formato JSON.
@RequestMapping("/api/libros") //  define la URL base de todos los endpoints de este controller.
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping // obtener datos
    public List<Libro> obtenerTodos() {
        return libroService.obtenerTodos();
    }

    @GetMapping("/buscar") // endpoint de búsqueda: GET /api/libros/buscar?autor=Cervantes o ?titulo=Quijote
    public ResponseEntity<List<Libro>> buscar(
        @RequestParam(required = false) String autor,
        @RequestParam(required = false) String titulo) {

    if (autor != null) {
        return ResponseEntity.ok(libroService.buscarPorAutor(autor));
    } else if (titulo != null) {
        return ResponseEntity.ok(libroService.buscarPorTitulo(titulo));
    } else {
        return ResponseEntity.badRequest().build(); // si no se pasa ningún parámetro devuelve error
    }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        return libroService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    

    @PostMapping // crear datos
    public Libro crear(@Valid @RequestBody Libro libro) { // @Valid activa las validaciones definidas en el modelo
        return libroService.guardar(libro);
    }

    @PutMapping("/{id}") // actualizar datos
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @Valid @RequestBody Libro libro) { // pathvariable captura el valor que viene en la URL
        return libroService.obtenerPorId(id)                        // requestbody coge el json de la peticion y lo convierte en libro
                .map(l -> {
                    libro.setId(id);
                    return ResponseEntity.ok(libroService.guardar(libro));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") // borrar datos
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}