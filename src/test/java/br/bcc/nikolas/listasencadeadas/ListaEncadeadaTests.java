package br.bcc.nikolas.listasencadeadas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ListaEncadeadaTests {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("Testa a inserção de um elemento numero x de vezes.")
    void testInserir_01(int tam) {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        String expected = "";

        for (int i = 1; i <= tam; i++) {
            listaEncadeada.inserir(i);
            expected += i + ",";
        }

        expected = expected.substring(0, expected.length() - 1);

        assertThat(listaEncadeada.toString()).hasToString(expected);
    }

    @Test
    @DisplayName("Testa se a lista está vazia (true)")
    void testEstaVazia_01() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();

        assertThat(listaEncadeada.estaVazia()).isTrue();
    }

    @Test
    @DisplayName("Testa se a lista está vazia (false)")
    void testEstaVazia_02() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();

        listaEncadeada.inserir(1);

        assertThat(listaEncadeada.estaVazia()).isFalse();
        assertThat(listaEncadeada.toString()).hasToString("1");
    }

    @Test
    @DisplayName("Testa se a lista está vazia (true)")
    void testEstaVazia_03() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();

        listaEncadeada.inserir(1);
        listaEncadeada.retirar(1);

        assertThat(listaEncadeada.estaVazia()).isTrue();
    }

    @Test
    @DisplayName("Testa buscar um numero que existe.")
    void testBuscar_01() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        NoLista<?> esperado = new NoLista<>(1);

        for (int i = 1; i <= 20; i++) {
            listaEncadeada.inserir(i);
        }

        assertThat(listaEncadeada.buscar(1))
                .isNotNull()
                .isEqualTo(esperado);
    }

    @ParameterizedTest
    @ValueSource(ints = {21, -1, 90})
    @DisplayName("Testa buscar um numero que não existe.")
    void testBuscar_02(int esperado) {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();

        for (int i = 1; i <= 20; i++) {
            listaEncadeada.inserir(i);
        }

        assertThat(listaEncadeada.buscar(esperado)).isNull();
    }

    @Test
    @DisplayName("Testa buscar o ultimo numero.")
    void testBuscar_03() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        NoLista<?> esperado = new NoLista<>(20);

        for (int i = 1; i <= 20; i++) {
            listaEncadeada.inserir(i);
        }

        assertThat(listaEncadeada.buscar(20))
                .isNotNull()
                .isEqualTo(esperado);
    }

    @Test
    @DisplayName("Testa a exclusão de um numero")
    void testRetirar_01() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        String expected = "1,2,3,5,6,7";

        for (int i = 1; i <= 7; i++) {
            listaEncadeada.inserir(i);
        }

        listaEncadeada.retirar(4);

        assertThat(listaEncadeada.toString()).hasToString(expected);
    }

    @Test
    @DisplayName("Testa a exclusão do primeiro node")
    void testRetirar_02() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        String expected = "2,3,4,5,6,7";

        for (int i = 1; i <= 7; i++) {
            listaEncadeada.inserir(i);
        }

        listaEncadeada.retirar(1);

        assertThat(listaEncadeada.toString()).hasToString(expected);
    }

    @Test
    @DisplayName("Testa a exclusão do último node")
    void testRetirar_03() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        String expected = "1,2,3,4,5,6";

        for (int i = 1; i <= 7; i++) {
            listaEncadeada.inserir(i);
        }

        listaEncadeada.retirar(7);

        assertThat(listaEncadeada.toString()).hasToString(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 8, 20})
    @DisplayName("Testa a exclusão de um node que nao existe")
    void testRetirar_04(int num) {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        String expected = "1,2,3,4,5,6,7";

        for (int i = 1; i <= 7; i++) {
            listaEncadeada.inserir(i);
        }

        listaEncadeada.retirar(num);

        assertThat(listaEncadeada.toString()).hasToString(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,1", "3,4", "6,7"})
    @DisplayName("Testa a busca de um node")
    void testObterNo_01(int idx, int valor) {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        NoLista<?> esperado = new NoLista<>(valor);

        for (int i = 1; i <= 7; i++) {
            listaEncadeada.inserir(i);
        }

        assertThat(listaEncadeada.obterNo(idx))
                .isNotNull()
                .isEqualTo(esperado);
    }

    @Test
    @DisplayName("Testa a busca de um node que nao existe")
    void testObterNo_02() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();

        for (int i = 1; i <= 7; i++) {
            listaEncadeada.inserir(i);
        }

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> listaEncadeada.obterNo(9));
    }

    @Test
    @DisplayName("Testa a busca de um node que nao existe, com a estrutura vazia")
    void testObterNo_03() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        assertThat(listaEncadeada.obterNo(0)).isNull();
    }

    @Test
    @DisplayName("Testa obter comprimento")
    void testObterComprimento_01() {
        int tam = 5;
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();

        for (int i = 0; i < tam; i++) {
            listaEncadeada.inserir(i);
        }

        assertThat(listaEncadeada.obterComprimento()).isEqualTo(tam);
    }

    @Test
    @DisplayName("Testa obter comprimento, com lista vazia.")
    void testObterComprimento_02() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        assertThat(listaEncadeada.obterComprimento()).isZero();
    }

    @Test
    @DisplayName("Testa toString() vazio")
    void testToString_01() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        assertThat(listaEncadeada.toString()).isEmpty();
    }

    @Test
    @DisplayName("Testa toString() vazio")
    void testToString_02() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();

        listaEncadeada.inserir(1);
        listaEncadeada.inserir(2);
        listaEncadeada.inserir(3);

        assertThat(listaEncadeada.toString()).hasToString("1,2,3");
    }

    @Test
    void testAA() {
        ListaEncadeada<Integer> l = new ListaEncadeada<>();

        l.inserir(20);
        l.inserir(20);
        l.inserir(20);
        l.inserir(20);
        l.inserir(20);
        l.inserir(10);
        l.inserir(20);

        l.retirarTodos(20);
        System.out.println(l);
    }


}
