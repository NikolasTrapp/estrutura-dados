package br.bcc.nikolas.lists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ListaEstaticaTests {

    @Test
    @DisplayName("Testar método de inclusão de dados na lista")
    void testAdd_01() {
        ListaEstatica list = new ListaEstatica();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        assertThat(list.getTamanho()).isEqualTo(4);
        assertThat(list.toString()).hasToString("5,10,15,20");
    }

    @Test
    @DisplayName("Testar método de busca")
    void testFind_01() {
        ListaEstatica list = new ListaEstatica();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        assertThat(list.buscar(15)).isEqualTo(2);
        assertThat(list.buscar(30)).isEqualTo(-1);
    }

    @Test
    @DisplayName("Testar método de remoção")
    void testRemove_01() {
        ListaEstatica list = new ListaEstatica();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        assertThat(list.retirar(10)).isTrue();
        assertThat(list.toString()).hasToString("5,15,20");
        assertThat(list.getTamanho()).isEqualTo(3);
    }

    @Test
    @DisplayName("Testar método de remoção de um elemento inexistente")
    void testRemove_02() {
        ListaEstatica list = new ListaEstatica();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        assertThat(list.retirar(90)).isFalse();
        assertThat(list.toString()).hasToString("5,10,15,20");
        assertThat(list.getTamanho()).isEqualTo(4);
    }

    @Test
    @DisplayName("Testar método de inclusão de dados na lista, testando redimencionamento.")
    void testAdd_02() {
        ListaEstatica list = new ListaEstatica();

        for (int i = 1; i <= 15; i++) {
            list.inserir(i);
        }

        assertThat(list.getTamanho()).isEqualTo(15);
        assertThat(list.toString()).hasToString("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15");
    }

    @Test
    @DisplayName("Testar método de obter elemento")
    void testGetNumber_01() {
        ListaEstatica list = new ListaEstatica();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        assertThat(list.obterElemento(3)).isEqualTo(20);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, -1})
    @DisplayName("Erro, testar método de obter elemento, exceção")
    void testGetNumber_02(int n) {
        ListaEstatica list = new ListaEstatica();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.obterElemento(n))
                .withMessage("Chapou linguiça");
    }

    @Test
    @DisplayName("Testa limpar a lista.")
    void testFree_01() {
        ListaEstatica list = new ListaEstatica();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        list.liberar();

        assertThat(list.getTamanho()).isZero();
        assertThat(list.estaVazia()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11})
    @DisplayName("Testa a inversão da lista, testa com caso impar e par")
    void testInversion_01(int x) {
        ListaEstatica list = new ListaEstatica();
        String expected = "";

        for (int i = 1; i <= x; i++) {
            list.inserir(i);
        }

        for (int i = x; i > 0; i--) {
            expected += i + ",";
        }

        expected = expected.substring(0, expected.length() - 1);

        list.inverter();

        assertThat(list.toString()).hasToString(expected);
    }

    @Test
    @DisplayName("Testa inversão com lista vazia")
    void testInversion_02() {
        ListaEstatica list = new ListaEstatica();

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(list::inverter)
                .withMessage("Ta chapando?");
    }
}
