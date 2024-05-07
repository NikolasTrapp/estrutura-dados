package br.bcc.nikolas.arvores.arvoresnarias;

public class Arvore <T> {

    private NoArvore<T> raiz;

    public boolean pertence(T info) {
        if (info == null) {
            throw new IllegalArgumentException();
        }

        if (raiz == null) {
            return false;
        }

        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no == null) {
            return false;
        }

        if (info.equals(no.getInfo())) {
            return true;
        }

        if (pertence(no.getPrimeiro(), info)) {
            return true;
        }
        if (pertence(no.getProximo(), info)) {
            return true;
        }

        return false;
    }

    public int contarNos() {
        if (raiz == null) {
            return 0;
        }
        return conarNos(raiz);
    }

    private int conarNos(NoArvore<T> no) {
        int count = 1;
        if (no.getPrimeiro() != null) {
            count += conarNos(no.getPrimeiro());
        }

        if (no.getProximo() != null) {
            count += conarNos(no.getProximo());
        }
        return count;
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        StringBuilder sb = new StringBuilder("<" + no.getInfo());

        NoArvore<T> atual = no.getPrimeiro();
        while (atual != null) {
            sb.append(obterRepresentacaoTextual(atual));
            atual = atual.getProximo();
        }
        sb.append(">");
        return sb.toString();
    }


    @Override
    public String toString() {
        if (raiz == null) {
            return "";
        }
        return obterRepresentacaoTextual(raiz);
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }
}
