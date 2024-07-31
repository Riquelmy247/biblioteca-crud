package com.api.biblioteca.dto;

import com.api.biblioteca.model.*;

public record LivroDTO (Autor autor, Categoria categoria, Editora editora, Avaliacao avaliacao, Idioma idioma, Paginas paginas, DescricaoLivro descricaoLivro, PrecoLivro precoLivro, String titulo){}
