package br.bcc.nikolas;

import br.bcc.nikolas.listaduplamenteencadeada.ListaDupla;

public class App {

    public static void main(String[] args) {
        ListaDupla<Integer> l = new ListaDupla<>();


        for (int i = 1; i <= 20; i++) {
            l.inserir(i);
        }

        System.out.println(l);
        l.liberar();
        System.out.println(l);
    }
}
