package br.bcc.nikolas.lists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GenericStaticListTests {

    @Test
    @DisplayName("Testar método de inclusão de dados na lista")
    void testAdd_01() {
        GenericStaticList list = new GenericStaticList();

        list.add(5);
        list.add("10");
        list.add(15.4);
        list.add(20);

        assertThat(list.getSize()).isEqualTo(4);
        assertThat(list.toString()).hasToString("5,10,15.4,20");
    }

    @Test
    @DisplayName("Testar método de busca")
    void testFind_01() {
        GenericStaticList list = new GenericStaticList();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        assertThat(list.find(15)).isEqualTo(2);
        assertThat(list.find(30)).isEqualTo(-1);
    }

    @Test
    @DisplayName("Testar método de remoção")
    void testRemove_01() {
        GenericStaticList list = new GenericStaticList();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        assertThat(list.remove(10)).isTrue();
        assertThat(list.toString()).hasToString("5,15,20");
        assertThat(list.getSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("Testar método de remoção de um elemento inexistente")
    void testRemove_02() {
        GenericStaticList list = new GenericStaticList();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        assertThat(list.remove(90)).isFalse();
        assertThat(list.toString()).hasToString("5,10,15,20");
        assertThat(list.getSize()).isEqualTo(4);
    }

    @Test
    @DisplayName("Testar método de inclusão de dados na lista, testando redimencionamento.")
    void testAdd_02() {
        GenericStaticList list = new GenericStaticList();

        for (int i = 1; i <= 15; i++) {
            list.add(i);
        }

        assertThat(list.getSize()).isEqualTo(15);
        assertThat(list.toString()).hasToString("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15");
    }

    @Test
    @DisplayName("Testar método de obter elemento")
    void testGetNumber_01() {
        GenericStaticList list = new GenericStaticList();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        assertThat(list.getNumber(3)).isEqualTo(20);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, -1})
    @DisplayName("Erro, testar método de obter elemento, exceção")
    void testGetNumber_02(int n) {
        GenericStaticList list = new GenericStaticList();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.getNumber(n))
                .withMessage("Chapou linguiça");
    }

    @Test
    @DisplayName("Testa limpar a lista.")
    void testFree_01() {
        GenericStaticList list = new GenericStaticList();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        list.free();

        assertThat(list.getSize()).isZero();
        assertThat(list.isEmpty()).isTrue();
    }
}
