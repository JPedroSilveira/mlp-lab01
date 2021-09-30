package com.joaopedrosilveira.mlp.entities.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import com.joaopedrosilveira.mlp.entities.Aluno;
import com.joaopedrosilveira.mlp.enumerator.NivelAluno;
import com.joaopedrosilveira.mlp.enumerator.Sexo;

import org.junit.jupiter.api.Test;

public class AlunoCopyTest {
    @Test
    void copyDtNascimentoAttribute() {
        final LocalDate dtNascimento = LocalDate.now().minusYears(18);
        final Aluno aluno = new Aluno("José", dtNascimento, Sexo.MASCULINO, "01001010", NivelAluno.INDEFINIDO);
        final Aluno copy = new Aluno(aluno);

        assertEquals(copy.getDtnascimento(), aluno.getDtnascimento());
    }

    @Test
    void cloneNomeAttribute() {
        final String nome = "Maria";
        final Aluno aluno = new Aluno(nome, LocalDate.now().minusYears(18), Sexo.MASCULINO, "01001010", NivelAluno.INDEFINIDO);
        final Aluno copy = new Aluno(aluno);

        assertEquals(copy.getNome(), aluno.getNome());
    }

    @Test
    void cloneSexoAttribute() {
        final Sexo sexo = Sexo.INDEFINIDO;
        final Aluno aluno = new Aluno("José", LocalDate.now().minusYears(18), sexo, "01001010", NivelAluno.INDEFINIDO);
        final Aluno copy = new Aluno(aluno);

        assertEquals(copy.getSexo(), aluno.getSexo());
    }

    @Test
    void cloneCodigoAttribute() {
        final String codigo = "01001010";
        final Aluno aluno = new Aluno("José", LocalDate.now().minusYears(18), Sexo.INDEFINIDO, codigo, NivelAluno.INDEFINIDO);
        final Aluno copy = new Aluno(aluno);

        assertEquals(copy.getCodigo(), aluno.getCodigo());
    }

    @Test
    void cloneNivelAttribute() {
        final NivelAluno nivelAluno = NivelAluno.DOUTORADO;
        final Aluno aluno = new Aluno("José", LocalDate.now().minusYears(18), Sexo.INDEFINIDO, "01001010", nivelAluno);
        final Aluno copy = new Aluno(aluno);

        assertEquals(copy.getNivel(), aluno.getNivel());
    }
}
