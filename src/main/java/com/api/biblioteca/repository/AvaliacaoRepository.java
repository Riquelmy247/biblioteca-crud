package com.api.biblioteca.repository;

import com.api.biblioteca.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    Optional<Avaliacao> findById(int id);
    void deleteById(int id);
}
