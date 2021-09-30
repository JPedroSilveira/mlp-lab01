package com.joaopedrosilveira.mlp;

import java.time.LocalDate;

import com.joaopedrosilveira.mlp.entities.Aluno;
import com.joaopedrosilveira.mlp.entities.Pessoa;
import com.joaopedrosilveira.mlp.enumerator.Sexo;

public final class App {
    public static void main(String[] args) {
        printSeparator();
        exercicioA();
        printSeparator();

        printSeparator();
        exercicioB();
        printSeparator();

        printSeparator();
        exercicioC();
        printSeparator();
    }

    private static void exercicioA() {
        final Pessoa defaultPessoa = new Pessoa();
        final Pessoa personalizedPessoa = new Pessoa("Maria", LocalDate.now().minusYears(18), Sexo.FEMININO);
        final Pessoa invalidParamPessoa = new Pessoa("1Artur", LocalDate.now().plusDays(1), Sexo.MASCULINO);
        
        System.out.println(defaultPessoa);
        System.out.println(personalizedPessoa);
        System.out.println(invalidParamPessoa);
    }

    private static void exercicioB() {
        final Pessoa originPessoa = new Pessoa();
        final Pessoa clonePessoa = originPessoa.clone();
        final Pessoa copyPessoa = new Pessoa(originPessoa);
        originPessoa.setNome("teste");

        System.out.println(originPessoa);
        System.out.println(clonePessoa);
        System.out.println(copyPessoa);
    }

    private static void exercicioC() {
        final Aluno defaultAluno = new Aluno();
        System.out.println(defaultAluno);

        final Aluno invalidAluno = new Aluno();
        final String invalidNome = "1Invalid";
        invalidAluno.setNome(invalidNome);
        System.out.println(invalidAluno);
    }

    private static void printSeparator() {
        System.out.println("===========================");
    }
}
