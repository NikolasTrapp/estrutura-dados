package br.bcc.nikolas.pilhas;

import br.bcc.nikolas.listasencadeadas.ListaEncadeada;
import br.bcc.nikolas.listasencadeadas.NoLista;

public class PilhaLista <T> implements Pilha <T> {

    private ListaEncadeada<T> lista;

    public PilhaLista() {
        this.lista = new ListaEncadeada<>();
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        NoLista<T> val = lista.getUltimo();
        if (val == null) {
            throw new PilhaVaziaException("A pilha está vazia.");
        }

        lista.retirar(val.getInfo());
        return val.getInfo();
    }

    @Override
    public T peek() {
        NoLista<T> val = lista.getUltimo();
        if (val == null) {
            throw new PilhaVaziaException("A pilha está vazia.");
        }

        return val.getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.getPrimeiro() == null;
    }

    @Override
    public void liberar() {
        lista.liberar();
    }

    public int getTamanho() {
        return this.lista.obterComprimento();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
