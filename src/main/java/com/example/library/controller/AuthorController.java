package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorRepository repo;

    public AuthorController(AuthorRepository repo) {
        this.repo = repo;
    }

    // 1. Listar todos los autores
    @GetMapping
    public List<Author> findAll() {
        return repo.findAll();
    }

    // 2. Buscar un autor por ID
    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Autor no encontrado con id " + id));
    }

    // 3. Crear un nuevo autor
    @PostMapping
    public Author create(@RequestBody Author author) {
        return repo.save(author);
    }

    // 4. Actualizar un autor existente
    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        return repo.save(author);
    }

    // 5. Borrar un autor por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
