package com.joaopedrosilveira.mlp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {
    @Test
    void appCanRunWithoutError() throws Exception {
        final String[] args = new String[0]; 
        App.main(args);
        assertTrue(true);
    }
}
