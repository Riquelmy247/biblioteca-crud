package com.api.biblioteca.service;

import com.api.biblioteca.dto.LivroDTO;
import com.api.biblioteca.model.Livro;
import com.api.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public List<Livro> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de Livro", e);
        }
    }

    public Optional<Livro> getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a Livro com o ID: " + id, e);
        }
    }

    @Transactional
    public Livro save(LivroDTO dto) {
        try {
            Livro nova = new Livro();
            nova.setAutor(dto.autor());
            nova.setAvaliacao(dto.avaliacao());
            nova.setCategoria(dto.categoria());
            nova.setDescricaoLivro(dto.descricaoLivro());
            nova.setEditora(dto.editora());
            nova.setIdioma(dto.idioma());
            nova.setPaginas(dto.paginas());
            nova.setPrecoLivro(dto.precoLivro());
            nova.setTitulo(dto.titulo());
            return repository.save(nova);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a Livro", e);
        }
    }

    @Transactional
    public Livro update(int id, LivroDTO dto) {
        try {
            Livro update = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Livro não encontrada com o ID: " + id));

            update.setAutor(dto.autor());
            update.setAvaliacao(dto.avaliacao());
            update.setCategoria(dto.categoria());
            update.setDescricaoLivro(dto.descricaoLivro());
            update.setEditora(dto.editora());
            update.setIdioma(dto.idioma());
            update.setPaginas(dto.paginas());
            update.setPrecoLivro(dto.precoLivro());
            update.setTitulo(dto.titulo());
            return repository.save(update);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a Livro", e);
        }
    }

    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a Livro", e);
        }
    }
}
