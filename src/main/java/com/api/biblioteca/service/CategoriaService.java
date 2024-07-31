package com.api.biblioteca.service;

import com.api.biblioteca.dto.CategoriaDTO;
import com.api.biblioteca.model.Categoria;
import com.api.biblioteca.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> get() {
        try {
            return categoriaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de Categoria", e);
        }
    }

    public Optional<Categoria> getById(int id) {
        try {
            return categoriaRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter o Categoria com o ID: " + id, e);
        }
    }

    @Transactional
    public Categoria save(CategoriaDTO dto) {
        try {
            Categoria categoria = new Categoria();
            categoria.setNome(dto.nome());
            return categoriaRepository.save(categoria);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar Categoria", e);
        }
    }

    @Transactional
    public Categoria update(int id, CategoriaDTO dto) {
        try {
            Categoria categoria = categoriaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com o ID: " + id));

            categoria.setNome(dto.nome());
            return categoriaRepository.save(categoria);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a Categoria", e);
        }
    }

    @Transactional
    public void delete(int id) {
        try {
            categoriaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o Categoria", e);
        }
    }


}
