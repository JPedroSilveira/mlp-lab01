package com.joaopedrosilveira.mlp.entities.pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import com.joaopedrosilveira.mlp.entities.Pessoa;
import com.joaopedrosilveira.mlp.enumerator.Sexo;

import org.junit.jupiter.api.Test;

public class PessoaCopyTest {
    @Test
    void cloneSexoAttribute() {
        final Pessoa pessoa = new Pessoa("José", LocalDate.now().minusYears(18), Sexo.MASCULINO);
        final Pessoa copy = new Pessoa(pessoa);

        assertEquals(copy.getSexo(), pessoa.getSexo());
    }

    @Test
    void cloneNomeAttribute() {
        final Pessoa pessoa = new Pessoa("José", LocalDate.now().minusYears(18), Sexo.MASCULINO);
        final Pessoa copy = new Pessoa(pessoa);

        assertEquals(copy.getNome(), pessoa.getNome());
    }

    @Test
    void cloneDtNascimentoAttribute() {
        final Pessoa pessoa = new Pessoa("José", LocalDate.now().minusYears(18), Sexo.MASCULINO);
        final Pessoa copy = new Pessoa(pessoa);

        assertEquals(copy.getDtnascimento(), pessoa.getDtnascimento());
    }
}
