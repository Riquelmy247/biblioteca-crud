package com.api.biblioteca.dto;

import com.api.biblioteca.model.EnderecoCliente;
import com.api.biblioteca.model.Exemplar;

import java.util.Date;

public record ClienteDTO (Exemplar exemplar, EnderecoCliente enderecoCliente, String nome, String telefone, String email, String cpf, String cnpj, String observacoes, Date dataEmprestado, Date dataDevolucao, int devolvido){}
