package br.bcc.nikolas.arvores.arvorenaria;

import br.bcc.nikolas.arvores.arvoresnarias.Arvore;
import br.bcc.nikolas.arvores.arvoresnarias.NoArvore;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArvoreTests {


    @Test
    void testToString() {
        Arvore<Integer> arvore = buildArvore();

        assertThat(arvore).hasToString("<1<2<3<4>><5><11>><6><7<8><9<10>>>>");
    }


    @Test
    void testToString2() {
        Arvore<String> arvore = buildArvoreString();

        assertThat(arvore).hasToString("<1<2<3<4>><5><11>><6><7<8><9<10>>>>");
    }

    private Arvore<String> buildArvoreString() {
        NoArvore<String> html = new NoArvore<>("html");
        NoArvore<String> body = new NoArvore<>("body");
        NoArvore<String> h1 = new NoArvore<>("h1");
        NoArvore<String> p1 = new NoArvore<>("p");
        NoArvore<String> p2 = new NoArvore<>("p");

        html.setPrimeiro(body);

        body.setPrimeiro(p2);
        p2.setProximo(p1);
        p1.setProximo(h1);

        Arvore<String> a = new Arvore<>();
        a.setRaiz(html);
        return a;

    }

    @Test
    void testPertence() {
        Arvore<Integer> arvore = buildArvore();
        for (int i = 1; i <= 11; i++) {
            assertTrue(arvore.pertence(i));
        }
        assertFalse(arvore.pertence(0));
        assertFalse(arvore.pertence(12));
    }

    @Test
    void testContarNos() {
        Arvore<Integer> arvore = buildArvore();
        assertThat(arvore.contarNos()).isEqualTo(11);
    }

    private Arvore<Integer> buildArvore() {
        NoArvore<Integer> no1 = new NoArvore<>(1);
        NoArvore<Integer> no2 = new NoArvore<>(2);
        NoArvore<Integer> no3 = new NoArvore<>(3);
        NoArvore<Integer> no4 = new NoArvore<>(4);
        NoArvore<Integer> no5 = new NoArvore<>(5);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        NoArvore<Integer> no7 = new NoArvore<>(7);
        NoArvore<Integer> no8 = new NoArvore<>(8);
        NoArvore<Integer> no9 = new NoArvore<>(9);
        NoArvore<Integer> no10 = new NoArvore<>(10);
        NoArvore<Integer> no11 = new NoArvore<>(11);

        no1.setPrimeiro(no2);

        no2.setProximo(no6);
        no6.setProximo(no7);

        no2.setPrimeiro(no3);
        no3.setProximo(no5);
        no5.setProximo(no11);

        no3.setPrimeiro(no4);

        no7.setPrimeiro(no8);
        no8.setProximo(no9);

        no9.setPrimeiro(no10);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(no1);
        return arvore;
    }
}
