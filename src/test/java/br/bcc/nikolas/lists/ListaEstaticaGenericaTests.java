package br.bcc.nikolas.lists;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ListaEstaticaGenericaTests {

    @Test
    @DisplayName("Testar método de inclusão de dados na lista")
    void testAdd_01() {
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        Assertions.assertThat(list.getTamanho()).isEqualTo(4);
        assertThat(list.toString()).hasToString("5,10,15,20");
    }

    @Test
    @DisplayName("Testar método de busca")
    void testFind_01() {
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        Assertions.assertThat(list.buscar(15)).isEqualTo(2);
        Assertions.assertThat(list.buscar(30)).isEqualTo(-1);
    }

    @Test
    @DisplayName("Testar método de busca, causando npe")
    void testFind_02() {
        ListaEstaticaGenerica<String> list = new ListaEstaticaGenerica<>();

        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> list.buscar(null))
                .withMessage("Chapou linguiça");
    }

    @Test
    @DisplayName("Testar método de remoção")
    void testRemove_01() {
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        Assertions.assertThat(list.retirar(10)).isTrue();
        assertThat(list.toString()).hasToString("5,15,20");
        Assertions.assertThat(list.getTamanho()).isEqualTo(3);
    }

    @Test
    @DisplayName("Testar método de remoção de um elemento inexistente")
    void testRemove_02() {
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        Assertions.assertThat(list.retirar(90)).isFalse();
        assertThat(list.toString()).hasToString("5,10,15,20");
        Assertions.assertThat(list.getTamanho()).isEqualTo(4);
    }

    @Test
    void testRemove_03() {
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();

        for (int i = 0; i < 11; i++) {
            list.inserir(i);
        }

        Assertions.assertThat(list.retirar(1)).isTrue();
        Assertions.assertThat(list.getTamanho()).isEqualTo(10);
    }

    @Test
    @DisplayName("Testar método de inclusão de dados na lista, testando redimencionamento.")
    void testAdd_02() {
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();

        for (int i = 1; i <= 15; i++) {
            list.inserir(i);
        }

        Assertions.assertThat(list.getTamanho()).isEqualTo(15);
        assertThat(list.toString()).hasToString("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15");
    }

    @Test
    @DisplayName("Testar método de obter elemento")
    void testGetObject_01() {
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        Assertions.assertThat(list.obterElemento(3)).isEqualTo(20);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, -1})
    @DisplayName("Erro, testar método de obter elemento, exceção")
    void testGetObject_02(int n) {
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();

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
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();

        list.inserir(5);
        list.inserir(10);
        list.inserir(15);
        list.inserir(20);

        list.liberar();

        Assertions.assertThat(list.getTamanho()).isZero();
        Assertions.assertThat(list.estaVazia()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11})
    @DisplayName("Testa a inversão da lista, testa com caso impar e par")
    void testInversion_01(int x) {
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();
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
        ListaEstaticaGenerica<?> list = new ListaEstaticaGenerica<>();

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(list::inverter)
                .withMessage("Ta chapando?");
    }

    @Test
    void testRetirarElementos() {
        ListaEstaticaGenerica<Integer> list = new ListaEstaticaGenerica<>();

        list.inserir(10);
        list.inserir(20);
        list.inserir(30);
        list.inserir(40);
        list.inserir(50);
        list.inserir(60);
        list.inserir(70);
        list.inserir(80);


        list.retirarElementos(2, 4);

        assertThat(list).hasToString("10,20,60,70");
        assertThat(list.getTamanho()).isEqualTo(4);
    }
}
