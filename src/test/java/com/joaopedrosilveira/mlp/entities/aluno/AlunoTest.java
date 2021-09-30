package com.joaopedrosilveira.mlp.entities.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import com.joaopedrosilveira.mlp.entities.Aluno;
import com.joaopedrosilveira.mlp.entities.Pessoa;
import com.joaopedrosilveira.mlp.enumerator.NivelAluno;
import com.joaopedrosilveira.mlp.enumerator.Sexo;

import org.junit.jupiter.api.Test;

public class AlunoTest {
    @Test
    void emptyConstructorCreateAlunoWithNonNullNivel() {
        final Aluno aluno = new Aluno();
        assertNotNull(aluno.getNivel());
    }

    @Test
    void emptyConstructorCreateAlunoWithNonNullCodigo() {
        final Aluno aluno = new Aluno();
        assertNotNull(aluno.getCodigo());
    }


    @Test
    void emptyConstructorCreateAlunoWithNonEmptyCodigo() {
        final Aluno aluno = new Aluno();
        assertFalse(aluno.getCodigo().isEmpty());
    }

    @Test
    void emptyConstructorCreateAlunoWithNivelIndefinido() {
        final Aluno aluno = new Aluno();
        assertEquals(aluno.getNivel(), NivelAluno.INDEFINIDO);
    }

    @Test
    void emptyConstructorUsesPessoaDefaultNome() {
        final Pessoa pessoa = new Pessoa();
        final Aluno aluno = new Aluno();
        
        assertEquals(aluno.getNome(), pessoa.getNome());
    }

    @Test
    void emptyConstructorUsesPessoaDefaultSexo() {
        final Pessoa pessoa = new Pessoa();
        final Aluno aluno = new Aluno();
        
        assertEquals(aluno.getSexo(), pessoa.getSexo());
    }

    @Test
    void emptyConstructorUsesPessoaDefaultDtnascimento() {
        final Pessoa pessoa = new Pessoa();
        final Aluno aluno = new Aluno();
        
        assertEquals(aluno.getDtnascimento(), pessoa.getDtnascimento());
    }

    @Test
    void fullConstructorWithValidNivelWorks() {
        final NivelAluno validNivel = NivelAluno.DOUTORADO;
        final Aluno aluno = new Aluno("José", LocalDate.now().minusYears(18), Sexo.INDEFINIDO, "01001010", validNivel);
        
        assertEquals(aluno.getNivel(), validNivel);
    }

    @Test
    void fullConstructorWithValidCodigoWorks() {
        final String validCodigo = "01001010";
        final Aluno aluno = new Aluno("José", LocalDate.now().minusYears(18), Sexo.INDEFINIDO, validCodigo, NivelAluno.INDEFINIDO);
        
        assertEquals(aluno.getCodigo(), validCodigo);
    }

    @Test
    void fullConstructorWithInvalidCodigoUsesDefault() {
        final Aluno defaultAluno = new Aluno();

        final String invalidCodigo = "INVALID_CODIGO";
        final Aluno aluno = new Aluno("José", LocalDate.now().minusYears(18), Sexo.INDEFINIDO, invalidCodigo, NivelAluno.INDEFINIDO);
        
        assertEquals(aluno.getCodigo(), defaultAluno.getCodigo());
        assertNotEquals(aluno.getCodigo(), invalidCodigo);
    }

    @Test
    void onSetInvalidCodigoKeepLastValidCodigo() {
        final String validCodigo = "01001010";
        final String invalidCodigo = "INVALID_CODIGO";

        final Aluno aluno = new Aluno("José", LocalDate.now().minusYears(18), Sexo.INDEFINIDO, validCodigo, NivelAluno.INDEFINIDO);
        aluno.setCodigo(invalidCodigo);

        assertEquals(aluno.getCodigo(), validCodigo);
        assertNotEquals(aluno.getCodigo(), invalidCodigo);
    }

    @Test
    void fullConstructorWithValidNomeWorks() {
        final String validNome = "Maria";
        final Aluno aluno = new Aluno(validNome, LocalDate.now().minusYears(18), Sexo.INDEFINIDO, "01001010", NivelAluno.INDEFINIDO);
        
        assertEquals(aluno.getNome(), validNome);
    }

    @Test
    void fullConstructorWithInvalidNomeUsesDefault() {
        final Aluno defaultAluno = new Aluno();

        final String invalidNome = "1Invalid";
        final Aluno aluno = new Aluno(invalidNome, LocalDate.now().minusYears(18), Sexo.INDEFINIDO, "01001010", NivelAluno.INDEFINIDO);
        
        assertEquals(aluno.getNome(), defaultAluno.getNome());
        assertNotEquals(aluno.getNome(), invalidNome);
    }

    @Test
    void onSetInvalidNomeKeepLastValidNome() {
        final String validNome = "José";
        final String invalidNome = "1InvalidName";

        final Aluno aluno = new Aluno(validNome, LocalDate.now().minusYears(18), Sexo.INDEFINIDO, "01001010", NivelAluno.INDEFINIDO);
        aluno.setNome(invalidNome);

        assertEquals(aluno.getNome(), validNome);
        assertNotEquals(aluno.getNome(), invalidNome);
    }


    @Test
    void fullConstructorWithValidDtnascimentoWorks() {
        final LocalDate validDtnascimento = LocalDate.now().minusDays(1);
        final Aluno aluno = new Aluno("José", validDtnascimento, Sexo.INDEFINIDO, "01001010", NivelAluno.INDEFINIDO);
        
        assertEquals(aluno.getDtnascimento(), validDtnascimento);
    }

    @Test
    void fullConstructorWithInvalidDtnascimentoUsesDefault() {
        final Aluno defaultAluno = new Aluno();

        final LocalDate invalidDtnascimento = LocalDate.now().plusDays(1);
        final Aluno aluno = new Aluno("José", invalidDtnascimento, Sexo.INDEFINIDO, "01001010", NivelAluno.INDEFINIDO);
        
        assertEquals(aluno.getDtnascimento(), defaultAluno.getDtnascimento());
        assertNotEquals(aluno.getDtnascimento(), invalidDtnascimento);
    }

    @Test
    void onSetInvalidDtnascimentoKeepLastValidNome() {
        final LocalDate validDtnascimento = LocalDate.now().minusYears(18);
        final LocalDate invalidDtnascimento = LocalDate.now().plusDays(1);

        final Aluno aluno = new Aluno("José", validDtnascimento, Sexo.INDEFINIDO, "01001010", NivelAluno.INDEFINIDO);
        aluno.setDtnascimento(invalidDtnascimento);

        assertEquals(aluno.getDtnascimento(), validDtnascimento);
        assertNotEquals(aluno.getDtnascimento(), invalidDtnascimento);
    }

    @Test
    void fullConstructorWithValidSexoWorks() {
        final Sexo validSexo = Sexo.FEMININO;
        final Aluno aluno = new Aluno("José", LocalDate.now().minusYears(18), validSexo, "01001010", NivelAluno.INDEFINIDO);
        
        assertEquals(aluno.getSexo(), validSexo);
    }
}
