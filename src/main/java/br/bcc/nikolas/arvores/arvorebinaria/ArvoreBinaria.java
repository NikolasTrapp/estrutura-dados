package br.bcc.nikolas.arvores.arvorebinaria;

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        int nos = 1;
        if (no.getEsquerda() != null) {
            nos += contarNos(no.getEsquerda());
        }
        if (no.getDireita() != null) {
            nos += contarNos(no.getDireita());
        }
        return nos;

    }

    public boolean pertence(T valor) {
        if (estaVazia()) {
            return false;
        }

        return pertence(raiz, valor);
    }

    public boolean pertence(NoArvoreBinaria<T> no, T valor) {
        if (valor.equals(no.getInfo())) {
            return true;
        }

        if (no.getEsquerda() != null) {
            return pertence(no.getEsquerda(), valor);
        }

        if (no.getDireita() != null) {
            return pertence(no.getDireita(), valor);
        }
        return false;
    }



    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        return null;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            throw new IllegalStateException();
        }
        return printNode(raiz);
    }

    private String printNode(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" +
                printNode(no.getEsquerda()) +
                printNode(no.getDireita()) +
                no.getInfo() +
                ">";
    }
}
