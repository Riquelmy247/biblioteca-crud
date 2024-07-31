package com.api.biblioteca.controller;

import com.api.biblioteca.dto.PaginasDTO;
import com.api.biblioteca.model.Paginas;
import com.api.biblioteca.service.PaginasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private PaginasService service;

    @GetMapping
    public ResponseEntity<List<Paginas>> get() {
        List<Paginas> paginas = service.get();
        return new ResponseEntity<>(paginas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paginas> getById(@PathVariable int id) {
        Optional<Paginas> paginas = service.getById(id);
        return paginas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paginas> save(@RequestBody PaginasDTO dto) {
        Paginas paginas = service.save(dto);
        return ResponseEntity.ok(paginas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paginas> update(@PathVariable int id, @RequestBody PaginasDTO dto) {
        Paginas paginas = service.update(id, dto);
        return ResponseEntity.ok(paginas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Preco Livro excluída com sucesso");
    }
}
