package br.bcc.nikolas;

import br.bcc.nikolas.listasencadeadas.ListaEncadeada;
import br.bcc.nikolas.lists.ListaEstatica;

public class App {

    public static void main(String[] args) {
        ListaEncadeada<Integer> l = new ListaEncadeada<>();


        for (int i = 1; i <= 20; i++) {
            l.inserir(i);
        }

        System.out.println(l.obterNo(0));
        System.out.println(l.obterNo(19));
    }
}
