package com.api.biblioteca.service;

import com.api.biblioteca.dto.PrecoLivroDTO;
import com.api.biblioteca.model.PrecoLivro;
import com.api.biblioteca.repository.PrecoLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class PrecoLivroService {

    @Autowired
    private PrecoLivroRepository repository;

    public List<PrecoLivro> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de Preco Livro", e);
        }
    }

    public Optional<PrecoLivro> getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a Preco Livro com o ID: " + id, e);
        }
    }

    @Transactional
    public PrecoLivro save(PrecoLivroDTO dto) {
        try {
            PrecoLivro nova = new PrecoLivro();
            nova.setPreco(dto.preco());
            return repository.save(nova);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a Preco Livro", e);
        }
    }

    @Transactional
    public PrecoLivro update(int id, PrecoLivroDTO dto) {
        try {
            PrecoLivro precoLivro = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Preco Livro não encontrada com o ID: " + id));

            precoLivro.setPreco(dto.preco());
            return repository.save(precoLivro);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a Preco Livro", e);
        }
    }

    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a Preco Livro", e);
        }
    }
}
