package com.api.biblioteca.controller;

import com.api.biblioteca.dto.ExemplarDTO;
import com.api.biblioteca.model.Exemplar;
import com.api.biblioteca.service.ExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exemplar")
public class ExemplarController {

    @Autowired
    private ExemplarService service;

    @GetMapping
    public ResponseEntity<List<Exemplar>> get() {
        List<Exemplar> exemplar = service.get();
        return new ResponseEntity<>(exemplar, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exemplar> getById(@PathVariable int id) {
        Optional<Exemplar> exemplar = service.getById(id);
        return exemplar.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Exemplar> save(@RequestBody ExemplarDTO dto) {
        Exemplar exemplar = service.save(dto);
        return ResponseEntity.ok(exemplar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exemplar> update(@PathVariable int id, @RequestBody ExemplarDTO dto) {
        Exemplar exemplar = service.update(id, dto);
        return ResponseEntity.ok(exemplar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Preco Livro excluída com sucesso");
    }
}
