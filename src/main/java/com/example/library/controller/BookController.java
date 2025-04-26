package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    // Listar todos los libros
    @GetMapping
    public List<Book> findAll() {
        return repo.findAll();
    }

    // Buscar libro por ID
    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Libro no encontrado con id " + id));
    }

    // Crear libro
    @PostMapping
    public Book create(@RequestBody Book book) {
        return repo.save(book);
    }

    // Actualizar libro
    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return repo.save(book);
    }

    // Borrar libro
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
