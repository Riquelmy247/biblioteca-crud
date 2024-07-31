package com.api.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @OneToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;
    @OneToOne
    @JoinColumn(name = "id_avaliacao")
    private Avaliacao avaliacao;
    @OneToOne
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;
    @OneToOne
    @JoinColumn(name = "id_paginas")
    private Paginas paginas;
    @OneToOne
    @JoinColumn(name = "id_descricao_livro")
    private DescricaoLivro descricaoLivro;
    @OneToOne
    @JoinColumn(name = "id_preco_livro")
    private PrecoLivro precoLivro;
    @Column(name = "titulo")
    private String titulo;

    public Livro(){}

    public Livro(int id, Autor autor, Categoria categoria, Editora editora, Avaliacao avaliacao, Idioma idioma, Paginas paginas, DescricaoLivro descricaoLivro, PrecoLivro precoLivro, String titulo) {
        this.id = id;
        this.autor = autor;
        this.categoria = categoria;
        this.editora = editora;
        this.avaliacao = avaliacao;
        this.idioma = idioma;
        this.paginas = paginas;
        this.descricaoLivro = descricaoLivro;
        this.precoLivro = precoLivro;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Paginas getPaginas() {
        return paginas;
    }

    public void setPaginas(Paginas paginas) {
        this.paginas = paginas;
    }

    public DescricaoLivro getDescricaoLivro() {
        return descricaoLivro;
    }

    public void setDescricaoLivro(DescricaoLivro descricaoLivro) {
        this.descricaoLivro = descricaoLivro;
    }

    public PrecoLivro getPrecoLivro() {
        return precoLivro;
    }

    public void setPrecoLivro(PrecoLivro precoLivro) {
        this.precoLivro = precoLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
