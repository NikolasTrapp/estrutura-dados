package br.bcc.nikolas.lists;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ListaEstaticaGenerica<T> {

    private static final int PART_SIZE = 10;
    private static final Integer ZERO = 0;
    private int tamanho = 0;
    private Object[] info;

    /**
     * Starts a new list with initial {@value PART_SIZE} tamanho.
     */
    public ListaEstaticaGenerica() {
        this.info = new Object[PART_SIZE];
    }

    private void redimensionar() {
        Object[] tempObjects = new Object[tamanho + PART_SIZE];
        for (int i = 0; i < getTamanho(); i++) {
            tempObjects[i] = info[i];
        }
        this.info = tempObjects;
    }

    public void inserir(T object) {
        if (this.info.length == tamanho) {
            redimensionar();
        }
        this.info[tamanho] = object;
        this.tamanho++;
    }

    public void exibir() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
        for (Object object : info) {
            System.out.println(object);
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public int buscar(T object) {
        if (isNull(object)) {
            throw new NullPointerException("Chapou linguiça");
        }
        for (int i = 0; i < getTamanho(); i++) {
            if (object.equals(info[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean retirar(T object) {
        int index = buscar(object);

        if (index == -1) {
            return false;
        }

        for (int i = index; i < getTamanho(); i++) {
            if (i == tamanho) {
                info[i] = null;
            } else {
                info[i] = info[i + 1];
            }
        }
        this.tamanho--;
        return true;
    }

    public void liberar() {
        this.info = new Object[PART_SIZE];
        this.tamanho = ZERO;
    }

    public T obterElemento(int index) {
        if (index > getTamanho() || index < 0) {
            throw new IndexOutOfBoundsException("Chapou linguiça");
        }

        return (T) info[index];
    }

    public boolean estaVazia() {
        return ZERO.equals(getTamanho());
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getTamanho(); i++) {
            if (nonNull(info[i])) {
                sb.append(info[i].toString());
                if (i < getTamanho() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public void inverter() {
        if (getTamanho() <= 0) {
            throw new IllegalStateException("Ta chapando?");
        }

        int s = (getTamanho() - 1) / 2;

        for (int i = 0; i <= s; i++) {
            int opposite = getTamanho() - 1 - i;
            Object temp = this.info[i];
            this.info[i] = this.info[opposite];
            this.info[opposite] = temp;
        }
    }

    public void retirarElementos(int inicio, int fim) {

        int diferenca = fim - inicio + 1;

        int count = 0;
        while (count < diferenca) {
            info[inicio + count] = info[fim + count + 1];
            count++;
        }

        for (int i = fim + 1; i < tamanho; i++) {
            info[i] = null;
        }

        tamanho -= (fim - inicio);
    }
}
