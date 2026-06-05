package com.carlos.biblioteca.repository;

import com.carlos.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository // le dice a Spring que esta interfaz es la capa de acceso a datos para que la gestione automáticamente
public interface LibroRepository extends JpaRepository<Libro, Long> { // trabajamos con la entidad libro y su pk es tipo Longs

    // JPA genera automáticamente: SELECT * FROM libros WHERE autor LIKE %autor%
    List<Libro> findByAutorContainingIgnoreCase(String autor);

    // JPA genera automáticamente: SELECT * FROM libros WHERE titulo LIKE %titulo%
    List<Libro> findByTituloContainingIgnoreCase(String titulo);    

}