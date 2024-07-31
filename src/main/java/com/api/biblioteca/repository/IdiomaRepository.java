package com.api.biblioteca.repository;


import com.api.biblioteca.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdiomaRepository extends JpaRepository<Idioma, Long> {
    Optional<Idioma> findById(int id);
    void deleteById(int id);
}
