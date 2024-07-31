package com.api.biblioteca.repository;

import com.api.biblioteca.model.EnderecoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoClienteRepository extends JpaRepository<EnderecoCliente, Long> {
    Optional<EnderecoCliente> findById(int id);
    void deleteById(int id);
}
