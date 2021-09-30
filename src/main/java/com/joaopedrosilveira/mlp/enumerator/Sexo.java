package com.joaopedrosilveira.mlp.enumerator;

public enum Sexo {
    INDEFINIDO("Indefinido"), MASCULINO("Masculino"), FEMININO("Feminino");

    private final String value;       

    private Sexo(String value) {
        this.value = value;
    }

    public String toString() {
       return this.value;
    }
}
