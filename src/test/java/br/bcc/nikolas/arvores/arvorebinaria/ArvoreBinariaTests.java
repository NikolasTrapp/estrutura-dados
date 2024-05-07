package br.bcc.nikolas.arvores.arvorebinaria;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArvoreBinariaTests {

    @Test
    void testInserir() {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(5);
        arvore.inserir(7);
        arvore.inserir(9);
        arvore.inserir(11);
        arvore.inserir(6);
        arvore.inserir(8);
        arvore.inserir(10);
        arvore.inserir(12);

        assertThat(arvore.contarNos()).isEqualTo(8);

        arvore.retirar(8);

        assertTrue(arvore.pertence(5));
        assertTrue(arvore.pertence(7));
        assertFalse(arvore.pertence(1));
        assertFalse(arvore.pertence(8));
        System.out.println(arvore.toString());


    }
}
