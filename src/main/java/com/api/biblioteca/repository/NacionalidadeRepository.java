package com.api.biblioteca.repository;

import com.api.biblioteca.model.Nacionalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NacionalidadeRepository extends JpaRepository<Nacionalidade, Long> {
    Optional<Nacionalidade> findById(int id);
    void deleteById(int id);
    Optional<Nacionalidade> findByNacionalidade(String nacionalidade);
}
