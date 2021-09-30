package com.joaopedrosilveira.mlp.entities;


import java.time.LocalDate;

import com.joaopedrosilveira.mlp.enumerator.Sexo;
import com.joaopedrosilveira.mlp.utils.DateUtils;

public class Pessoa {
    private String nome;
    private LocalDate dtnascimento;
    private Sexo sexo;

    public Pessoa() {
        setDefaultValues();
    }
    
    public Pessoa(String nome, LocalDate dtnascimento, Sexo sexo) {
        setDefaultValues();
        setNome(nome);
        setDtnascimento(dtnascimento);
        this.sexo = sexo;
    }

    public Pessoa(Pessoa pessoa) {
        this(pessoa.getNome(), pessoa.getDtnascimento(), pessoa.getSexo());
    }

    private void setDefaultValues() {
        this.nome = "NOME INDEFINIDO";
        this.dtnascimento = LocalDate.now();
        this.sexo = Sexo.INDEFINIDO;
    }

    private Boolean isValidNome(String nome) {
        return nome != null && !nome.isEmpty() && !Character.isDigit(nome.charAt(0));
    }

    private Boolean isValidDtNascimento(LocalDate dtnascimento) {
        return !dtnascimento.isAfter(LocalDate.now());
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (isValidNome(nome)) {
            this.nome = nome;
        }
    }
    public LocalDate getDtnascimento() {
        return dtnascimento;
    }
    public void setDtnascimento(LocalDate dtnascimento) {
        if (isValidDtNascimento(dtnascimento)) {
            this.dtnascimento = dtnascimento;
        }
    }
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("Nome: ")
            .append(this.nome)
            .append('\n')
            .append("Data de nascimento: ")
            .append(DateUtils.dateToFormattedString(this.dtnascimento))
            .append('\n')
            .append("Sexo: ")
            .append(this.sexo.toString())
            .toString();
    }

    @Override
    public Pessoa clone() {
        return new Pessoa(this);
    }
}
