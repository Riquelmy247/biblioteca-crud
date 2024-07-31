package com.api.biblioteca.service;

import com.api.biblioteca.dto.AutorDTO;
import com.api.biblioteca.model.Autor;
import com.api.biblioteca.model.Nacionalidade;
import com.api.biblioteca.repository.AutorRepository;
import com.api.biblioteca.repository.NacionalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private NacionalidadeRepository nacionalidadeRepository;

    public List<Autor> getAutor() {
        try {
            return autorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de Autor", e);
        }
    }

    public Optional<Autor> getAutorById(int id) {
        try {
            return autorRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter o Autor com o ID: " + id, e);
        }
    }

    @Transactional
    public Autor saveAutor(AutorDTO dto) {
        try {
            Autor autor = new Autor();

            Nacionalidade nacionalidade = nacionalidadeRepository.findByNacionalidade(dto.nacionalidade().nacionalidade())
                    .orElseGet(() -> {
                        Nacionalidade newNacionalidade = new Nacionalidade();
                        newNacionalidade.setNacionalidade(dto.nacionalidade().nacionalidade());
                        return nacionalidadeRepository.save(newNacionalidade);
                    });

            autor.setNacionalidade(nacionalidade);
            autor.setBiografia(dto.biografia());
            autor.setNome(dto.nome());
            autor.setDataNascimento(dto.dataNascimento());
            return autorRepository.save(autor);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o autor", e);
        }
    }

    @Transactional
    public Autor updateAutor(int id, AutorDTO dto) {
        try {
            Autor autor = autorRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Autor não encontrada com o ID: " + id));

            Nacionalidade nacionalidade = nacionalidadeRepository.findByNacionalidade(dto.nacionalidade().nacionalidade())
                    .orElseGet(() -> {
                        Nacionalidade newNacionalidade = new Nacionalidade();
                        newNacionalidade.setNacionalidade(dto.nacionalidade().nacionalidade());
                        return nacionalidadeRepository.save(newNacionalidade);
                    });

            autor.setNacionalidade(nacionalidade);
            autor.setNome(dto.nome());
            autor.setBiografia(dto.biografia());
            autor.setDataNascimento(dto.dataNascimento());
            return autorRepository.save(autor);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a Autor", e);
        }
    }

    @Transactional
    public void deleteAutor(int id) {
        try {
            autorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o Autor", e);
        }
    }


}
