package com.api.biblioteca.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne
    @JoinColumn(name = "id_exemplar")
    private Exemplar exemplar;
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private EnderecoCliente enderecoCliente;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "data_emprestado")
    private Date dataEmprestado;
    @Column(name = "data_devolucao")
    private Date dataDevolucao;
    @Column(name = "devolvido")
    private int devolvido;

    public Cliente(){}

    public Cliente(int id, Exemplar exemplar, EnderecoCliente enderecoCliente, String nome, String telefone, String email, String cpf, String cnpj, String observacoes, Date dataEmprestado, Date dataDevolucao, int devolvido) {
        this.id = id;
        this.exemplar = exemplar;
        this.enderecoCliente = enderecoCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.observacoes = observacoes;
        this.dataEmprestado = dataEmprestado;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public EnderecoCliente getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(EnderecoCliente enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getDataEmprestado() {
        return dataEmprestado;
    }

    public void setDataEmprestado(Date dataEmprestado) {
        this.dataEmprestado = dataEmprestado;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(int devolvido) {
        this.devolvido = devolvido;
    }
}
