package br.bcc.nikolas.pilhas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PilhaListaTests {

    @Test
    void testEstaVazia_01() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        assertThat(pilha.estaVazia()).isTrue();
    }

    @Test
    void testEstaVazia_02() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);

        assertThat(pilha.estaVazia()).isFalse();
    }

    @Test
    void testEstaVazia_03() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.pop();
        pilha.pop();
        pilha.pop();

        assertThat(pilha.estaVazia()).isTrue();
    }

    @Test
    void testPush_01() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        assertThat(pilha.peek()).isEqualTo(10);
        pilha.push(20);
        assertThat(pilha.peek()).isEqualTo(20);
        pilha.push(30);
        assertThat(pilha.peek()).isEqualTo(30);
        pilha.push(40);
        assertThat(pilha.peek()).isEqualTo(40);
        pilha.push(50);
        assertThat(pilha.peek()).isEqualTo(50);

        assertThat(pilha.getTamanho()).isEqualTo(5);

        pilha.pop();
        assertThat(pilha.peek()).isEqualTo(40);
        pilha.pop();
        assertThat(pilha.peek()).isEqualTo(30);
        pilha.pop();
        assertThat(pilha.peek()).isEqualTo(20);
        pilha.pop();
        assertThat(pilha.peek()).isEqualTo(10);
        pilha.pop();
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(pilha::peek);

        assertThat(pilha.getTamanho()).isEqualTo(0);
    }

    @Test
    void testPop_01() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(pilha::pop);
    }

    @Test
    void testPeek_01() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);

        assertThat(pilha.peek()).isEqualTo(40);
        assertThat(pilha.getTamanho()).isEqualTo(4);
    }


    @Test
    void testLiberar_01() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);

        pilha.liberar();

        assertThat(pilha.getTamanho()).isZero();
        assertThat(pilha.estaVazia()).isTrue();
    }

}
