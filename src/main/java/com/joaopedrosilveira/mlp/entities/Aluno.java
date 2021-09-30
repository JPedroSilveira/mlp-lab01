package com.joaopedrosilveira.mlp.entities;

import java.time.LocalDate;

import com.joaopedrosilveira.mlp.enumerator.NivelAluno;
import com.joaopedrosilveira.mlp.enumerator.Sexo;

public class Aluno extends Pessoa {
    private String codigo;
    private NivelAluno nivel;

    public Aluno() {
        super();
        setDefaultValues();
    }

    public Aluno(String nome, LocalDate dtnascimento, Sexo sexo, String codigo, NivelAluno nivel) {
        super(nome, dtnascimento, sexo);
        setDefaultValues();
        setCodigo(codigo);
        this.nivel = nivel;
    }

    public Aluno(Aluno aluno) {
        this(aluno.getNome(), aluno.getDtnascimento(), aluno.getSexo(), aluno.getCodigo(), aluno.getNivel());
    }

    private void setDefaultValues() {
        this.codigo = "00000000";
        this.nivel = NivelAluno.INDEFINIDO;
    }

    private Boolean isValidCodigo(String codigo) {
        return codigo.matches("[0-9]+");
    }   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (isValidCodigo(codigo)) {
            this.codigo = codigo;
        }
    }

    public NivelAluno getNivel() {
        return nivel;
    }

    public void setNivel(NivelAluno nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append(super.toString())
            .append('\n')
            .append("Código: ")
            .append(this.codigo)
            .append('\n')
            .append("Nível: ")
            .append(this.nivel)
            .toString();
    }

    @Override
    public Aluno clone() {
        return new Aluno(this);
    }
}
