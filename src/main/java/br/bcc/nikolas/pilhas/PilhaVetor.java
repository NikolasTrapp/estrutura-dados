package br.bcc.nikolas.pilhas;

public class PilhaVetor <T> implements Pilha <T> {

    private T[] info;
    private final int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.limite = limite;
        this.tamanho = 0;
        this.info = (T[]) new Object[limite];
    }

    @Override
    public void push(T info) {
        if (tamanho == limite) {
            throw new PilhaCheiaExcepion("Pilha cheia.");
        }
        this.info[tamanho] = info;
        tamanho++;
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException("A pilha está vazia.");
        }
        T val = this.info[tamanho - 1];
        this.info[tamanho - 1] = null;
        tamanho--;
        return val;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException("A pilha está vazia.");
        }

        return this.info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return getTamanho() == 0;
    }

    @Override
    public void liberar() {
        this.info = (T[]) new Object[getLimite()];

        T val = pop();
        while (val != null) {
            val = pop();
        }

        this.tamanho = 0;
    }

    void concatenar(PilhaVetor<T> p) {
        if (getTamanho() + p.getTamanho() > limite) {
            throw new PilhaCheiaExcepion("Limite de tamanho estourado.");
        }


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        while(this.info[count] != null) {
            sb.append(info[count]).append(",");
            count++;
        }
        return sb.substring(0, sb.length()-1);
    }

    public int getLimite() {
        return limite;
    }

    public int getTamanho() {
        return tamanho;
    }
}
