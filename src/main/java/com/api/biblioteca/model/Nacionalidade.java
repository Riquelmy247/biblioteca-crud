package com.api.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nacionalidade")
public class Nacionalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nacionalidade")
    private String nacionalidade;

    public Nacionalidade(int id, String nacionalidade) {
        this.id = id;
        this.nacionalidade = nacionalidade;
    }

    public Nacionalidade() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
