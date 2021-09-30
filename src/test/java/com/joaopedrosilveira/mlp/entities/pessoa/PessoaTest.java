package com.joaopedrosilveira.mlp.entities.pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import com.joaopedrosilveira.mlp.entities.Pessoa;
import com.joaopedrosilveira.mlp.enumerator.Sexo;

import org.junit.jupiter.api.Test;

public class PessoaTest {
    @Test
    void emptyConstructorCreatePessoaWithNonNullNome() {
        final Pessoa pessoa = new Pessoa();
        assertNotNull(pessoa.getNome());
    }

    @Test
    void emptyConstructorCreatePessoaWithNonNullSexo() {
        final Pessoa pessoa = new Pessoa();
        assertNotNull(pessoa.getSexo());
    }

    @Test
    void emptyConstructorCreatePessoaWithNonNullDtnascimento() {
        final Pessoa pessoa = new Pessoa();
        assertNotNull(pessoa.getDtnascimento());
    }


    @Test
    void emptyConstructorCreatePessoaWithTodayAsDtnascimento() {
        final Pessoa pessoa = new Pessoa();
        assertTrue(LocalDate.now().isEqual(pessoa.getDtnascimento()));
    }

    @Test
    void emptyConstructorCreatePessoaWithIndefinedSexo() {
        final Pessoa pessoa = new Pessoa();
        assertEquals(pessoa.getSexo(), Sexo.INDEFINIDO);
    }

    @Test
    void emptyConstructorCreatePessoaWithNonEmptyName() {
        final Pessoa pessoa = new Pessoa();
        assertFalse(pessoa.getNome().isEmpty());
    }

    @Test
    void fullConstructorWithValidNameWorks() {
        final String validName = "José";
        final Pessoa pessoa = new Pessoa(validName, LocalDate.now().minusYears(18), Sexo.INDEFINIDO);

        assertEquals(pessoa.getNome(), validName);
    }

    @Test
    void fullConstructorWithInvalidNameCreatePessoaWithDefaultName() {
        final String invalidNome = "1InvalidName";
        final Pessoa pessoa = new Pessoa(invalidNome, LocalDate.now().minusYears(18), Sexo.INDEFINIDO);

        final Pessoa defaultPessoa = new Pessoa();

        assertEquals(pessoa.getNome(), defaultPessoa.getNome());
        assertNotEquals(pessoa.getNome(), invalidNome);
    }

    @Test
    void onSetInvalidNomeKeepLastValidNome() {
        final String validNome = "José";
        final String invalidNome = "1InvalidName";

        final Pessoa pessoa = new Pessoa(validNome, LocalDate.now().minusYears(18), Sexo.INDEFINIDO);
        pessoa.setNome(invalidNome);

        assertEquals(pessoa.getNome(), validNome);
        assertNotEquals(pessoa.getNome(), invalidNome);
    }

    @Test
    void fullConstructorWithValidDtnascimentoWorks() {
        final LocalDate validDtNascimento = LocalDate.now();
        final Pessoa pessoa = new Pessoa("Maria", validDtNascimento, Sexo.INDEFINIDO);

        assertEquals(pessoa.getDtnascimento(), validDtNascimento);
    }

    @Test
    void fullConstructorWithInvalidDtnascimentoCreatePessoaWithDefaultDtnascimento() {
        final LocalDate invalidDtnascimento = LocalDate.now().plusDays(1);
        final Pessoa pessoa = new Pessoa("Maria", invalidDtnascimento, Sexo.INDEFINIDO);

        final Pessoa defaultPessoa = new Pessoa();

        assertEquals(pessoa.getDtnascimento(), defaultPessoa.getDtnascimento());
        assertNotEquals(pessoa.getDtnascimento(), invalidDtnascimento);
    }

    @Test
    void onSetInvalidDtnascimentoKeepLastValidNome() {
        final LocalDate validDtnascimento = LocalDate.now().minusYears(18);
        final LocalDate invalidDtnascimento = LocalDate.now().plusDays(1);

        final Pessoa pessoa = new Pessoa("Maria", validDtnascimento, Sexo.INDEFINIDO);
        pessoa.setDtnascimento(invalidDtnascimento);

        assertEquals(pessoa.getDtnascimento(), validDtnascimento);
        assertNotEquals(pessoa.getDtnascimento(), invalidDtnascimento);
    }

    @Test
    void fullConstructorWithValidSexoWorks() {
        final Sexo validSexo = Sexo.MASCULINO;
        final Pessoa pessoa = new Pessoa("Maria", LocalDate.now().minusYears(18), validSexo);

        assertEquals(pessoa.getSexo(), validSexo);
    }
}
