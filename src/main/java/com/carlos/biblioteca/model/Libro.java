package com.carlos.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity // con esto provocamos que JPA cree la tabla en la base de datos
@Table(name = "libros") // esto es para decirle el nombre que va a tener en la base de datos
public class Libro {

    @Id // con esto marcamos cual es la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // el id se genera automáticamente de forma incremental
    private Long id;

    @NotBlank(message = "El título no puede estar vacío") // no permite strings vacíos o en blanco
    private String titulo;

    @NotBlank(message = "El autor no puede estar vacío") // no permite strings vacíos o en blanco
    private String autor;

    @Min(value = 1, message = "El año debe ser mayor que 0") // el año mínimo permitido es 1
    @Max(value = 2026, message = "El año no puede ser futuro") // el año máximo permitido es 2026
    private int anioPublicacion;

    // Constructor vacío (obligatorio para JPA)
    public Libro() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }
}