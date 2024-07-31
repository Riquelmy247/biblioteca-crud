package com.api.biblioteca.service;

import com.api.biblioteca.dto.NacionalidadeDTO;
import com.api.biblioteca.model.Nacionalidade;
import com.api.biblioteca.repository.NacionalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class NacionalidadeService {

    @Autowired
    private NacionalidadeRepository nacionalidadeRepository;

    public List<Nacionalidade> getNacionalidade() {
        try {
            return nacionalidadeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de nacionalidades", e);
        }
    }

    public Optional<Nacionalidade> getNacionalidadeById(int id) {
        try {
            return nacionalidadeRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a nacionalidade com o ID: " + id, e);
        }
    }

    @Transactional
    public Nacionalidade saveNacionalidade(NacionalidadeDTO dto) {
        try {
            Nacionalidade novaNacionalidade = new Nacionalidade();
            novaNacionalidade.setNacionalidade(dto.nacionalidade());
            return nacionalidadeRepository.save(novaNacionalidade);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a nacionalidade", e);
        }
    }

    @Transactional
    public Nacionalidade updateNacionalidade(int id, NacionalidadeDTO dto) {
        try {
            Nacionalidade existingNacionalidade = nacionalidadeRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Nacionalidade não encontrada com o ID: " + id));

            existingNacionalidade.setNacionalidade(dto.nacionalidade());
            return nacionalidadeRepository.save(existingNacionalidade);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a nacionalidade", e);
        }
    }

    @Transactional
    public void deleteNacionalidade(int id) {
        try {
            nacionalidadeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a nacionalidade", e);
        }
    }
}
