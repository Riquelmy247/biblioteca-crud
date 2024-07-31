package com.api.biblioteca.repository;

import com.api.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findById(int id);
    void deleteById(int id);
}
