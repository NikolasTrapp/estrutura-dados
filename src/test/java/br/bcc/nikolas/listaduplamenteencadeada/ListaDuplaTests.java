package br.bcc.nikolas.listaduplamenteencadeada;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static java.util.Objects.nonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ListaDuplaTests {


    @Test
    @DisplayName("Testa a inserção de dados na lista")
    void testInserir() {
        ListaDupla<Integer> l = new ListaDupla<>();

        l.inserir(1);
        l.inserir(2);
        l.inserir(3);
        l.inserir(4);

        assertThat(l).hasToString("4,3,2,1");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 20, 5})
    @DisplayName("Testa a operação de busca")
    void testBusca_01(Integer x) {
        ListaDupla<Integer> l = new ListaDupla<>();

        for (int i = 1; i <= 20; i++) {
            l.inserir(i);
        }

        assertNotNull(l.buscar(x));
        assertThat(l.buscar(x).getInfo()).isEqualTo(x);
    }

    @Test
    @DisplayName("Testa busca null")
    void testBusca_02() {
        ListaDupla<Integer> l = new ListaDupla<>();

        for (int i = 1; i <= 20; i++) {
            l.inserir(i);
        }

        assertNull(l.buscar(21));
        assertNull(l.buscar(-1));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1;20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2",
            "20;19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1",
            "5;20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,4,3,2,1",
            "21;20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1"
    }, delimiter = ';')
    @DisplayName("Testa a remoção de valores")
    void testRemover(Integer x, String expected) {
        ListaDupla<Integer> l = new ListaDupla<>();

        for (int i = 1; i <= 20; i++) {
            l.inserir(i);
        }


        l.retirar(x);

        NoListaDupla<Integer> anterior = l.buscar(x + 1);
        NoListaDupla<Integer> posterior = l.buscar(x - 1);

        if (nonNull(anterior)) {
            assertThat(anterior.getProximo()).isEqualTo(posterior);
        }

        if (nonNull(posterior)) {
            assertThat(posterior.getAnterior()).isEqualTo(anterior);
        }
        assertThat(l).hasToString(expected);
    }

    @Test
    @DisplayName("Testa se todos os objetos foram liberados")
    void testLiberar() {
        ListaDupla<Integer> l = new ListaDupla<>();

        l.inserir(1);
        l.inserir(2);
        l.inserir(3);
        l.inserir(4);

        NoListaDupla<Integer> n1 = l.buscar(1);
        NoListaDupla<Integer> n2 = l.buscar(2);
        NoListaDupla<Integer> n3 = l.buscar(3);
        NoListaDupla<Integer> n4 = l.buscar(4);

        l.liberar();

        assertNull(n1.getProximo());
        assertNull(n1.getAnterior());
        assertNull(n2.getProximo());
        assertNull(n2.getAnterior());
        assertNull(n3.getProximo());
        assertNull(n3.getAnterior());
        assertNull(n4.getProximo());
        assertNull(n4.getAnterior());

        assertThat(l).hasToString("");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Testa a listagem inversa. Ausencia de erro = sucesso.")
    void testInversao(Integer x) {
        ListaDupla<Integer> l = new ListaDupla<>();

        for (int i = 1; i <= x; i++) {
            l.inserir(i);
        }

        assertDoesNotThrow(l::exibirOrdemInversa);
    }

    @Test
    @DisplayName("Testa toString()")
    void testToString_01() {
        ListaDupla<Integer> l = new ListaDupla<>();

        for (int i = 1; i <= 3; i++) {
            l.inserir(i);
        }

        assertThat(l).hasToString("3,2,1");
    }

    @Test
    @DisplayName("Testa toString()")
    void testToString_02() {
        ListaDupla<Integer> l = new ListaDupla<>();

        l.inserir(1);

        assertThat(l).hasToString("1");
    }

    @Test
    @DisplayName("Testa toString()")
    void testToString_03() {
        ListaDupla<Integer> l = new ListaDupla<>();

        assertThat(l).hasToString("");
    }

}
