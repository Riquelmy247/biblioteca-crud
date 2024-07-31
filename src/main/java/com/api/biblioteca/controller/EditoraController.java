package com.api.biblioteca.controller;

import com.api.biblioteca.dto.EditoraDTO;
import com.api.biblioteca.model.Editora;
import com.api.biblioteca.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/editora")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<Editora>> get() {
        List<Editora> editora = editoraService.get();
        return new ResponseEntity<>(editora, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> getById(@PathVariable int id) {
        Optional<Editora> editora = editoraService.getById(id);
        return editora.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Editora> save(@RequestBody EditoraDTO dto) {
        Editora editora = editoraService.save(dto);
        return ResponseEntity.ok(editora);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editora> update(@PathVariable int id, @RequestBody EditoraDTO dto) {
        Editora editora = editoraService.update(id, dto);
        return ResponseEntity.ok(editora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        editoraService.delete(id);
        return ResponseEntity.ok("Editora excluída com sucesso");
    }
}
