package br.bcc.nikolas;

import br.bcc.nikolas.lists.StaticList;

public class App {

    public static void main(String[] args) {
        StaticList lista = new StaticList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);

        lista.remove(3);

        lista.printNumbers();
        System.out.println(lista);
        System.out.println("--=-==-=-=-==-=-=");
        System.out.println(lista.numbers.length);
    }
}
