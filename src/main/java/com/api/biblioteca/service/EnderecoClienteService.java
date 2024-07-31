package com.api.biblioteca.service;

import com.api.biblioteca.dto.EnderecoClienteDTO;
import com.api.biblioteca.model.EnderecoCliente;
import com.api.biblioteca.repository.EnderecoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class EnderecoClienteService {

    @Autowired
    private EnderecoClienteRepository repository;

    public List<EnderecoCliente> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a lista de EnderecoCliente", e);
        }
    }

    public Optional<EnderecoCliente> getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a EnderecoCliente com o ID: " + id, e);
        }
    }

    @Transactional
    public EnderecoCliente save(EnderecoClienteDTO dto) {
        try {
            EnderecoCliente nova = new EnderecoCliente();
            nova.setEndereco(dto.endereco());
            nova.setBairro(dto.bairro());
            nova.setCep(dto.cep());
            nova.setCidade(dto.cidade());
            nova.setEstado(dto.estado());
            nova.setNumero(dto.numero());
            return repository.save(nova);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a EnderecoCliente", e);
        }
    }

    @Transactional
    public EnderecoCliente update(int id, EnderecoClienteDTO dto) {
        try {
            EnderecoCliente update = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("EnderecoCliente não encontrada com o ID: " + id));

            update.setEndereco(dto.endereco());
            update.setBairro(dto.bairro());
            update.setCep(dto.cep());
            update.setCidade(dto.cidade());
            update.setEstado(dto.estado());
            update.setNumero(dto.numero());
            return repository.save(update);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a EnderecoCliente", e);
        }
    }

    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a EnderecoCliente", e);
        }
    }
}
