package com.api.biblioteca.repository;

import com.api.biblioteca.model.DescricaoLivro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DescricaoLivroRepository extends JpaRepository<DescricaoLivro, Long> {
    Optional<DescricaoLivro> findById(int id);
    void deleteById(int id);
}
