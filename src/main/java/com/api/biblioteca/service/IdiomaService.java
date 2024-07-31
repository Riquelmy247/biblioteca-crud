package com.api.biblioteca.service;

import com.api.biblioteca.dto.IdiomaDTO;
import com.api.biblioteca.model.Idioma;
import com.api.biblioteca.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class IdiomaService {

    @Autowired
    private IdiomaRepository repository;

    public List<Idioma> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de Idioma", e);
        }
    }

    public Optional<Idioma> getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a Idioma com o ID: " + id, e);
        }
    }

    @Transactional
    public Idioma save(IdiomaDTO dto) {
        try {
            Idioma nova = new Idioma();
            nova.setNome(dto.nome());
            return repository.save(nova);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a Idioma", e);
        }
    }

    @Transactional
    public Idioma update(int id, IdiomaDTO dto) {
        try {
            Idioma idioma = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Idioma não encontrada com o ID: " + id));

            idioma.setNome(dto.nome());
            return repository.save(idioma);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a Idioma", e);
        }
    }

    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a Idioma", e);
        }
    }
}
