package com.api.biblioteca.repository;

import com.api.biblioteca.model.Paginas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaginasRepository extends JpaRepository<Paginas, Long> {
    Optional<Paginas> findById(int id);
    void deleteById(int id);
}
