package com.api.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "paginas")
public class Paginas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "quantidade")
    private int quantidade;

    public Paginas(){}

    public Paginas(int id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
