package br.bcc.nikolas.pilhas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PilhaVetorTests {

    @Test
    void testEstaVazia_01() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(1);

        assertThat(pilha.estaVazia()).isTrue();
    }

    @Test
    void testEstaVazia_02() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(1);

        pilha.push(1);

        assertThat(pilha.estaVazia()).isFalse();
    }

    @Test
    void testEstaVazia_03() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);

        pilha.push(10);
        assertThat(pilha.peek()).isEqualTo(10);
        pilha.push(20);
        assertThat(pilha.peek()).isEqualTo(20);
        pilha.push(30);
        assertThat(pilha.peek()).isEqualTo(30);

        pilha.pop();
        assertThat(pilha.peek()).isEqualTo(20);
        pilha.pop();
        assertThat(pilha.peek()).isEqualTo(10);
        pilha.pop();
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(pilha::peek);

        assertThat(pilha.estaVazia()).isTrue();
    }

    @Test
    void testPush_01() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

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
        assertThatExceptionOfType(PilhaCheiaExcepion.class).isThrownBy(() -> pilha.push(60));
    }

    @Test
    void testPop_01() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(pilha::pop);
    }

    @Test
    void testPeek_01() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);

        assertThat(pilha.peek()).isEqualTo(40);
        assertThat(pilha.getTamanho()).isEqualTo(4);
    }


    @Test
    void testLiberar_01() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);

        pilha.liberar();

        assertThat(pilha.getTamanho()).isZero();
        assertThat(pilha.estaVazia()).isTrue();
    }

}
