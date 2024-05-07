package br.bcc.nikolas.filas;

import java.util.Arrays;

public class FilaVetor <T> implements Fila <T> {

    private Object[] info;
    private int limite;
    private int inicio;
    private int tamanho;

    public FilaVetor(int limite) {
        this.limite = limite;
        this.info = new Object[limite];
        this.inicio = 0;
        this.tamanho = 0;
    }

    @Override
    public void inserir(T info) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }

        int pos = (inicio + tamanho) % limite;
        this.info[pos] = info;
        aumentarTamanho();
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (info.length == 0) {
            throw new FilaVaziaException();
        }

        return (T) info[inicio];
    }

    @Override
    public T retirar() {
        T valor = peek();
        inicio = (inicio + 1 ) % limite;
        diminuirTamanho();
        return valor;
    }

    @Override
    public void liberar() {

    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<>(f2.getLimite() + getLimite());

        int indice = inicio;
        for (int i = 0; i < tamanho; i++) {
            f3.inserir((T) this.info[indice]);
            indice = (inicio + 1) % limite;
        }

        indice = f2.inicio;
        for (int i = 0; i < f2.tamanho; i++) {
            f3.inserir((T) f2.info[indice]);
            indice = (inicio + 1) % limite;
        }
        return f3;
    }

    @Override
    public String toString() {
        return "FilaVetor{" +
                "info=" + Arrays.toString(info) +
                '}';
    }

    public int getLimite() {
        return limite;
    }

    private void aumentarTamanho() {
        this.tamanho++;
    }

    private void diminuirTamanho() {
        this.tamanho--;
    }

}
