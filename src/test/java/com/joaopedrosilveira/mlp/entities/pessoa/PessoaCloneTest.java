package com.joaopedrosilveira.mlp.entities.pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import com.joaopedrosilveira.mlp.entities.Pessoa;
import com.joaopedrosilveira.mlp.enumerator.Sexo;

import org.junit.jupiter.api.Test;

public class PessoaCloneTest {
    @Test
    void cloneSexoAttribute() {
        final Pessoa pessoa = new Pessoa("José", LocalDate.now().minusYears(18), Sexo.MASCULINO);
        final Pessoa clone = pessoa.clone();

        assertEquals(clone.getSexo(), pessoa.getSexo());
    }

    @Test
    void cloneNomeAttribute() {
        final String nome = "José";
        final Pessoa pessoa = new Pessoa(nome, LocalDate.now().minusYears(18), Sexo.MASCULINO);
        final Pessoa clone = pessoa.clone();

        assertEquals(clone.getDtnascimento(), pessoa.getDtnascimento());
    }

    @Test
    void cloneDtNascimentoAttribute() {
        final LocalDate dtNascimento = LocalDate.now().minusYears(18);
        final Pessoa pessoa = new Pessoa("José", dtNascimento, Sexo.MASCULINO);
        final Pessoa clone = pessoa.clone();

        assertEquals(clone.getDtnascimento(), pessoa.getDtnascimento());
    }
}
