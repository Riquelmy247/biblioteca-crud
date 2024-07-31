package com.api.biblioteca.controller;

import com.api.biblioteca.dto.AvaliacaoDTO;
import com.api.biblioteca.model.Avaliacao;
import com.api.biblioteca.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> get() {
        List<Avaliacao> avaliacaos = avaliacaoService.get();
        return new ResponseEntity<>(avaliacaos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> getById(@PathVariable int id) {
        Optional<Avaliacao> avaliacao = avaliacaoService.getById(id);
        return avaliacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Avaliacao> save(@RequestBody AvaliacaoDTO dto) {
        Avaliacao avaliacao = avaliacaoService.save(dto);
        return ResponseEntity.ok(avaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable int id, @RequestBody AvaliacaoDTO dto) {
        Avaliacao avaliacao = avaliacaoService.update(id, dto);
        return ResponseEntity.ok(avaliacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        avaliacaoService.delete(id);
        return ResponseEntity.ok("Avaliacao excluída com sucesso");
    }
}
