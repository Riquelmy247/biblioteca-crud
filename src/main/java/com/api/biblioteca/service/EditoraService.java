package com.api.biblioteca.service;

import com.api.biblioteca.dto.EditoraDTO;
import com.api.biblioteca.model.Editora;
import com.api.biblioteca.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public List<Editora> get() {
        try {
            return editoraRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de Editora", e);
        }
    }

    public Optional<Editora> getById(int id) {
        try {
            return editoraRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter o Editora com o ID: " + id, e);
        }
    }

    @Transactional
    public Editora save(EditoraDTO dto) {
        try {
            Editora editora = new Editora();
            editora.setNome(dto.nome());
            return editoraRepository.save(editora);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar editora", e);
        }
    }

    @Transactional
    public Editora update(int id, EditoraDTO dto) {
        try {
            Editora editora = editoraRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Editora não encontrada com o ID: " + id));

            editora.setNome(dto.nome());
            return editoraRepository.save(editora);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a Editora", e);
        }
    }

    @Transactional
    public void delete(int id) {
        try {
            editoraRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o Editora", e);
        }
    }


}
