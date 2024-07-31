package com.api.biblioteca.service;

import com.api.biblioteca.dto.ExemplarDTO;
import com.api.biblioteca.model.Exemplar;
import com.api.biblioteca.repository.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class ExemplarService {

    @Autowired
    private ExemplarRepository repository;

    public List<Exemplar> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de Exemplar", e);
        }
    }

    public Optional<Exemplar> getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a Exemplar com o ID: " + id, e);
        }
    }

    @Transactional
    public Exemplar save(ExemplarDTO dto) {
        try {
            Exemplar nova = new Exemplar();
            nova.setLivro(dto.livro());
            nova.setNumSerie(dto.numSerie());
            nova.setQuantidade(dto.quantidade());
            return repository.save(nova);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a Exemplar", e);
        }
    }

    @Transactional
    public Exemplar update(int id, ExemplarDTO dto) {
        try {
            Exemplar update = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Exemplar não encontrada com o ID: " + id));

            update.setLivro(dto.livro());
            update.setNumSerie(dto.numSerie());
            update.setQuantidade(dto.quantidade());
            return repository.save(update);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a Exemplar", e);
        }
    }

    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a Exemplar", e);
        }
    }
}
