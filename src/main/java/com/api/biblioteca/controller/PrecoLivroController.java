package com.api.biblioteca.controller;

import com.api.biblioteca.dto.PrecoLivroDTO;
import com.api.biblioteca.model.PrecoLivro;
import com.api.biblioteca.service.PrecoLivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/precoLivro")
public class PrecoLivroController {

    @Autowired
    private PrecoLivroService service;

    @GetMapping
    public ResponseEntity<List<PrecoLivro>> get() {
        List<PrecoLivro> precoLivro = service.get();
        return new ResponseEntity<>(precoLivro, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrecoLivro> getById(@PathVariable int id) {
        Optional<PrecoLivro> precoLivro = service.getById(id);
        return precoLivro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PrecoLivro> save(@RequestBody PrecoLivroDTO dto) {
        PrecoLivro precoLivro = service.save(dto);
        return ResponseEntity.ok(precoLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrecoLivro> update(@PathVariable int id, @RequestBody PrecoLivroDTO dto) {
        PrecoLivro precoLivro = service.update(id, dto);
        return ResponseEntity.ok(precoLivro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Preco Livro excluída com sucesso");
    }
}
