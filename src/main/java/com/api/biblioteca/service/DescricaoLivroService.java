package com.api.biblioteca.service;

import com.api.biblioteca.dto.DescricaoLivroDTO;
import com.api.biblioteca.model.DescricaoLivro;
import com.api.biblioteca.repository.DescricaoLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class DescricaoLivroService {

    @Autowired
    private DescricaoLivroRepository repository;

    public List<DescricaoLivro> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de Descricao Livro", e);
        }
    }

    public Optional<DescricaoLivro> getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a Descricao Livro com o ID: " + id, e);
        }
    }

    @Transactional
    public DescricaoLivro save(DescricaoLivroDTO dto) {
        try {
            DescricaoLivro nova = new DescricaoLivro();
            nova.setDescricao(dto.descricao());
            return repository.save(nova);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a Descricao Livro", e);
        }
    }

    @Transactional
    public DescricaoLivro update(int id, DescricaoLivroDTO dto) {
        try {
            DescricaoLivro descricaoLivro = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Descricao Livro não encontrada com o ID: " + id));

            descricaoLivro.setDescricao(dto.descricao());
            return repository.save(descricaoLivro);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a Descricao Livro", e);
        }
    }

    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a Descricao Livro", e);
        }
    }
}
