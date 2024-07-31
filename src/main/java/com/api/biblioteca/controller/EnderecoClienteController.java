package com.api.biblioteca.controller;

import com.api.biblioteca.dto.EnderecoClienteDTO;
import com.api.biblioteca.model.EnderecoCliente;
import com.api.biblioteca.service.EnderecoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enderecoCliente")
public class EnderecoClienteController {

    @Autowired
    private EnderecoClienteService service;

    @GetMapping
    public ResponseEntity<List<EnderecoCliente>> get() {
        List<EnderecoCliente> enderecoCliente = service.get();
        return new ResponseEntity<>(enderecoCliente, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoCliente> getById(@PathVariable int id) {
        Optional<EnderecoCliente> enderecoCliente = service.getById(id);
        return enderecoCliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EnderecoCliente> save(@RequestBody EnderecoClienteDTO dto) {
        EnderecoCliente enderecoCliente = service.save(dto);
        return ResponseEntity.ok(enderecoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoCliente> update(@PathVariable int id, @RequestBody EnderecoClienteDTO dto) {
        EnderecoCliente enderecoCliente = service.update(id, dto);
        return ResponseEntity.ok(enderecoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Preco Livro excluída com sucesso");
    }
}
