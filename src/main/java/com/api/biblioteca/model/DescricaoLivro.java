package com.api.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "descricao_livro")
public class DescricaoLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "descricao")
    private String descricao;

    public DescricaoLivro(){}

    public DescricaoLivro(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
