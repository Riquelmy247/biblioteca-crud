package com.api.biblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne
    @JoinColumn(name="id_nacionalidade")
    private Nacionalidade nacionalidade;
    @Column(name="nome")
    private String nome;
    @Column(name="data_nascimento")
    private LocalDate dataNascimento;
    @Column(name="biografia")
    private String biografia;

    public Autor(){}

    public Autor(int id, Nacionalidade nacionalidade, String nome, LocalDate dataNascimento, String biografia) {
        this.id = id;
        this.nacionalidade = nacionalidade;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.biografia = biografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}