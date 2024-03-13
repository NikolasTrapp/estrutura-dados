package br.bcc.nikolas.listasencadeadas;

import java.util.Objects;

public class NoLista <T> {

    private NoLista<T> proximo;
    private T info;

    public NoLista(T info) {
        this.info = info;
    }

    public NoLista<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return info.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoLista<?> noLista = (NoLista<?>) o;
        return Objects.equals(info, noLista.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }
}
