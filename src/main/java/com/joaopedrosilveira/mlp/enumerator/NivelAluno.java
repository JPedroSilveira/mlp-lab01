package com.joaopedrosilveira.mlp.enumerator;

public enum NivelAluno {
    INDEFINIDO("Indefinido"), GRADUACAO("Graduação"), ESPECIALIZACAO("Especialização"), MESTRADO("Mestrado"), DOUTORADO("Doutorado");

    private final String value;       

    private NivelAluno(String value) {
        this.value = value;
    }

    public String toString() {
       return this.value;
    }
}
