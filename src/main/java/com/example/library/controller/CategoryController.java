package com.example.library.controller;

import com.example.library.entity.Category;
import com.example.library.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository repo;

    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }

    // Listar todas las categorías
    @GetMapping
    public List<Category> findAll() {
        return repo.findAll();
    }

    // Buscar categoría por ID
    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id " + id));
    }

    // Crear categoría
    @PostMapping
    public Category create(@RequestBody Category category) {
        return repo.save(category);
    }

    // Actualizar categoría
    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return repo.save(category);
    }

    // Borrar categoría
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
