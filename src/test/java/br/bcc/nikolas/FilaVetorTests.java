package br.bcc.nikolas;

import br.bcc.nikolas.filas.FilaCheiaException;
import br.bcc.nikolas.filas.FilaVetor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FilaVetorTests {


    @Test
    void testInserir() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        fila.inserir(4);
        fila.inserir(5);


        assertThatExceptionOfType(FilaCheiaException.class)
                .isThrownBy(() -> fila.inserir(6));

        assertThat(fila.retirar()).isEqualTo(5);
        assertThat(fila.retirar()).isEqualTo(4);
        assertThat(fila.retirar()).isEqualTo(3);
        assertThat(fila.retirar()).isEqualTo(2);
        assertThat(fila.retirar()).isEqualTo(1);
    }
}
