package com.api.biblioteca.service;

import com.api.biblioteca.dto.AvaliacaoDTO;
import com.api.biblioteca.model.Avaliacao;
import com.api.biblioteca.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public List<Avaliacao> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de avaliacao", e);
        }
    }

    public Optional<Avaliacao> getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a avaliacao com o ID: " + id, e);
        }
    }

    @Transactional
    public Avaliacao save(AvaliacaoDTO dto) {
        try {
            Avaliacao nova = new Avaliacao();
            nova.setAvaliacao(dto.avaliacao());
            return repository.save(nova);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a avaliacao", e);
        }
    }

    @Transactional
    public Avaliacao update(int id, AvaliacaoDTO dto) {
        try {
            Avaliacao avaliacao = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Avaliacao não encontrada com o ID: " + id));

            avaliacao.setAvaliacao(dto.avaliacao());
            return repository.save(avaliacao);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a avaliacao", e);
        }
    }

    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a avaliacao", e);
        }
    }
}
