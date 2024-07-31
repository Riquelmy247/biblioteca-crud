package com.api.biblioteca.controller;

import com.api.biblioteca.dto.IdiomaDTO;
import com.api.biblioteca.model.Idioma;
import com.api.biblioteca.service.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/idioma")
public class IdiomaController {

    @Autowired
    private IdiomaService service;

    @GetMapping
    public ResponseEntity<List<Idioma>> get() {
        List<Idioma> idioma = service.get();
        return new ResponseEntity<>(idioma, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Idioma> getById(@PathVariable int id) {
        Optional<Idioma> idioma = service.getById(id);
        return idioma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Idioma> save(@RequestBody IdiomaDTO dto) {
        Idioma idioma = service.save(dto);
        return ResponseEntity.ok(idioma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Idioma> update(@PathVariable int id, @RequestBody IdiomaDTO dto) {
        Idioma idioma = service.update(id, dto);
        return ResponseEntity.ok(idioma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Preco Livro excluída com sucesso");
    }
}
