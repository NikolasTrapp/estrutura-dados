package br.bcc.nikolas;

import br.bcc.nikolas.lists.ListaEstatica;

public class App {

    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);
        lista.inserir(6);
        lista.inserir(7);
        lista.inserir(8);
        lista.inserir(9);

        lista.retirar(3);

        lista.exibir();
        System.out.println(lista);
        System.out.println("--=-==-=-=-==-=-=");
    }
}
