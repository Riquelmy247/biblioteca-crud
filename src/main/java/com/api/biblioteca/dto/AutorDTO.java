package com.api.biblioteca.dto;

import java.time.LocalDate;

public record AutorDTO(NacionalidadeDTO nacionalidade, String nome, LocalDate dataNascimento, String biografia) { }
