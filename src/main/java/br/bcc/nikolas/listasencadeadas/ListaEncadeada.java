package br.bcc.nikolas.listasencadeadas;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ListaEncadeada <T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;


    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {

        if (isNull(primeiro)) {
            this.primeiro = new NoLista<>(info);
            this.ultimo = new NoLista<>(info);
            return;
        }
        adicionarNo(getPrimeiro(), info);
        this.ultimo = new NoLista<>(info);
    }

    private void adicionarNo(NoLista<T> target, T info) {
        if (isNull(target.getProximo())) {
            target.setProximo(new NoLista<>(info));
            return;
        }
        adicionarNo(target.getProximo(), info);
    }

    public boolean estaVazia() {
        return isNull(getPrimeiro());
    }

    public NoLista<T> buscar(T info) {
        return buscarRecursivamente(getPrimeiro(), info);
    }

    private NoLista<T> buscarRecursivamente(NoLista<T> target, T info) {
        if (isNull(target)) {
            return null;
        }

        if (target.getInfo().equals(info)) {
            return target;
        }

        return buscarRecursivamente(target.getProximo(), info);
    }

    public void retirar(T info) {
        if (isNull(getPrimeiro())) {
            return;
        }

        if (info.equals(getPrimeiro().getInfo())) {
            this.primeiro = getPrimeiro().getProximo();
            return;
        }

        NoLista<T> p = getPrimeiro();
        while (nonNull(p)) {
            NoLista<T> alvo = p.getProximo();
            if (nonNull(alvo) && info.equals(alvo.getInfo())) {
                p.setProximo(alvo.getProximo());
                return;
            }
            p = p.getProximo();
        }
    }

    public int obterComprimento() {
        if (isNull(getPrimeiro())) {
            return 0;
        }

        int tam = 0;
        NoLista<T> p = getPrimeiro();
        while (nonNull(p)) {
            p = p.getProximo();
            tam++;
        }

        return tam;
    }

    public NoLista<T> obterNo(int idx) {
        if (isNull(getPrimeiro())) {
            return null;
        }

        NoLista<T> p = getPrimeiro();
        for (int i = 0; i < idx; i++) {
            if (isNull(p)) {
              throw new IllegalArgumentException("Chapo né parça, bora respeitar o tamanho ai...");
            }
            p = p.getProximo();
        }
        return p;
    }

    public void retirarTodos(T valor) {
        if (getPrimeiro() == null) {
            return;
        }

        NoLista<T> p = getPrimeiro();

        if (p.getInfo().equals(valor)) {
            while (p.getInfo().equals(valor)) {
                p = p.getProximo();
                if (p == null) {
                    primeiro = null;
                    return;
                }
            }
            primeiro = p;
        }

        while (p != null) {
            NoLista<T> prox = p.getProximo();
            if (prox != null && prox.getInfo().equals(valor)) {
                p.setProximo(prox.getProximo());
            } else {
                p = p.getProximo();
            }
        }
    }

    public void liberar() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public NoLista<T> getUltimo() {
        return ultimo;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (isNull(getPrimeiro())) {
            return str.toString();
        }

        NoLista<T> p = getPrimeiro();
        while (nonNull(p)) {
            str.append(p.getInfo()).append(",");
            p = p.getProximo();
        }

        return str.substring(0, str.length()-1);
    }
}
