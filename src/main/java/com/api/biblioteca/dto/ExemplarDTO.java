package com.api.biblioteca.dto;

import com.api.biblioteca.model.Livro;

public record ExemplarDTO (Livro livro, int numSerie, int quantidade){}
