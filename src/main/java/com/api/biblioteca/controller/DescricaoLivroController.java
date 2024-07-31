package com.api.biblioteca.controller;

import com.api.biblioteca.dto.DescricaoLivroDTO;
import com.api.biblioteca.model.DescricaoLivro;
import com.api.biblioteca.service.DescricaoLivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/descricaoLivro")
public class DescricaoLivroController {

    @Autowired
    private DescricaoLivroService service;

    @GetMapping
    public ResponseEntity<List<DescricaoLivro>> get() {
        List<DescricaoLivro> descricaoLivro = service.get();
        return new ResponseEntity<>(descricaoLivro, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DescricaoLivro> getById(@PathVariable int id) {
        Optional<DescricaoLivro> descricaoLivro = service.getById(id);
        return descricaoLivro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DescricaoLivro> save(@RequestBody DescricaoLivroDTO dto) {
        DescricaoLivro descricaoLivro = service.save(dto);
        return ResponseEntity.ok(descricaoLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DescricaoLivro> update(@PathVariable int id, @RequestBody DescricaoLivroDTO dto) {
        DescricaoLivro descricaoLivro = service.update(id, dto);
        return ResponseEntity.ok(descricaoLivro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("DescricaoLivro excluída com sucesso");
    }
}
