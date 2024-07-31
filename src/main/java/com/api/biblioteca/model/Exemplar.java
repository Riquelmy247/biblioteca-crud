package com.api.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exemplar")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;
    @Column(name = "num_serie")
    private int numSerie;
    @Column(name = "quantidade")
    private int quantidade;

    public Exemplar(){}

    public Exemplar(int id, Livro livro, int numSerie, int quantidade) {
        this.id = id;
        this.livro = livro;
        this.numSerie = numSerie;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
