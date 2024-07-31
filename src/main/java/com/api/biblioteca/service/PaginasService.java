package com.api.biblioteca.service;

import com.api.biblioteca.dto.PaginasDTO;
import com.api.biblioteca.model.Paginas;
import com.api.biblioteca.repository.PaginasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class PaginasService {

    @Autowired
    private PaginasRepository repository;

    public List<Paginas> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de Paginas", e);
        }
    }

    public Optional<Paginas> getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a Paginas com o ID: " + id, e);
        }
    }

    @Transactional
    public Paginas save(PaginasDTO dto) {
        try {
            Paginas nova = new Paginas();
            nova.setQuantidade(dto.quantidade());
            return repository.save(nova);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a Paginas", e);
        }
    }

    @Transactional
    public Paginas update(int id, PaginasDTO dto) {
        try {
            Paginas paginas = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Paginas não encontrada com o ID: " + id));

            paginas.setQuantidade(dto.quantidade());
            return repository.save(paginas);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a Paginas", e);
        }
    }

    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a Paginas", e);
        }
    }
}
