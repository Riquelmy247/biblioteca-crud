package com.api.biblioteca.controller;

import com.api.biblioteca.dto.AutorDTO;
import com.api.biblioteca.model.Autor;
import com.api.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> getAutor() {
        List<Autor> autor = autorService.getAutor();
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable int id) {
        Optional<Autor> autor = autorService.getAutorById(id);
        return autor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Autor> saveAutor(@RequestBody AutorDTO dto) {
        Autor saveAutor = autorService.saveAutor(dto);
        return ResponseEntity.ok(saveAutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable int id, @RequestBody AutorDTO dto) {
        Autor updatedAutor = autorService.updateAutor(id, dto);
        return ResponseEntity.ok(updatedAutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAutor(@PathVariable int id) {
        autorService.deleteAutor(id);
        return ResponseEntity.ok("Autor excluído com sucesso");
    }
}
