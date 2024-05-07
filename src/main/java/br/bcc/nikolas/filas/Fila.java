package br.bcc.nikolas.filas;

public interface Fila <T> {
    void inserir(T info);
    boolean estaVazia();
    T peek();
    T retirar();
    void liberar();

}
