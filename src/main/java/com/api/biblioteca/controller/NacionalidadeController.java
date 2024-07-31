package com.api.biblioteca.controller;

import com.api.biblioteca.dto.NacionalidadeDTO;
import com.api.biblioteca.model.Nacionalidade;
import com.api.biblioteca.service.NacionalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nacionalidade")
public class NacionalidadeController {

    @Autowired
    private NacionalidadeService nacionalidadeService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ResponseEntity<List<Nacionalidade>> getNacionalidade() {
        List<Nacionalidade> nacionalidades = nacionalidadeService.getNacionalidade();
        return new ResponseEntity<>(nacionalidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nacionalidade> getNacionalidadeById(@PathVariable int id) {
        Optional<Nacionalidade> nacionalidade = nacionalidadeService.getNacionalidadeById(id);
        return nacionalidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Nacionalidade> saveNacionalidade(@RequestBody NacionalidadeDTO dto) {
        Nacionalidade nacionalidade = nacionalidadeService.saveNacionalidade(dto);
        return ResponseEntity.ok(nacionalidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nacionalidade> updateNacionalidade(@PathVariable int id, @RequestBody NacionalidadeDTO dto) {
        Nacionalidade nacionalidade = nacionalidadeService.updateNacionalidade(id, dto);
        return ResponseEntity.ok(nacionalidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNacionalidade(@PathVariable int id) {
        nacionalidadeService.deleteNacionalidade(id);
        return ResponseEntity.ok("Nacionalidade excluída com sucesso");
    }
}
