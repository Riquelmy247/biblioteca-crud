package com.api.biblioteca.controller;

import com.api.biblioteca.dto.CategoriaDTO;
import com.api.biblioteca.model.Categoria;
import com.api.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> get() {
        List<Categoria> categoria = categoriaService.get();
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable int id) {
        Optional<Categoria> categoria = categoriaService.getById(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody CategoriaDTO dto) {
        Categoria categoria = categoriaService.save(dto);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable int id, @RequestBody CategoriaDTO dto) {
        Categoria categoria = categoriaService.update(id, dto);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        categoriaService.delete(id);
        return ResponseEntity.ok("Categoria excluída com sucesso");
    }
}
