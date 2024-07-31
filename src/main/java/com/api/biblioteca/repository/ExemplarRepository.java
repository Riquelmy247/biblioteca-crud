package com.api.biblioteca.repository;

import com.api.biblioteca.model.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
    Optional<Exemplar> findById(int id);
    void deleteById(int id);
}
