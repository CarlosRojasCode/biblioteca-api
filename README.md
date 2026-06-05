# Biblioteca API REST

API REST desarrollada con Spring Boot para la gestión de una biblioteca.

## Tecnologías utilizadas
- Java 23
- Spring Boot 3.5
- Spring Data JPA
- H2 Database (en memoria)
- Maven

## Funcionalidades
- CRUD completo de libros
- Validación de datos de entrada
- Manejo de errores personalizado
- Búsqueda por autor y título

## Endpoints

| Método | URL | Descripción |
|--------|-----|-------------|
| GET | /api/libros | Obtener todos los libros |
| GET | /api/libros/{id} | Obtener libro por ID |
| GET | /api/libros/buscar?autor= | Buscar por autor |
| GET | /api/libros/buscar?titulo= | Buscar por título |
| POST | /api/libros | Crear libro |
| PUT | /api/libros/{id} | Actualizar libro |
| DELETE | /api/libros/{id} | Eliminar libro |

## Cómo ejecutar el proyecto
1. Clonar el repositorio
2. Ejecutar `./mvnw spring-boot:run`
3. La API estará disponible en `http://localhost:8080`
