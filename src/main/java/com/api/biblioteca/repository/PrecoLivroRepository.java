package com.api.biblioteca.repository;

import com.api.biblioteca.model.PrecoLivro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrecoLivroRepository extends JpaRepository<PrecoLivro, Long> {
    Optional<PrecoLivro> findById(int id);
    void deleteById(int id);
}
