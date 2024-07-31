package com.api.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "preco_livro")
public class PrecoLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "preco")
    private double preco;

    public PrecoLivro() {}

    public PrecoLivro(int id, double preco) {
        this.id = id;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
