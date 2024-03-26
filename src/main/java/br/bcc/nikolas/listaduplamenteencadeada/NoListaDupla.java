package br.bcc.nikolas.listaduplamenteencadeada;

import static java.util.Objects.nonNull;

public class NoListaDupla <T> {

    private T info;
    private NoListaDupla<T> anterior;
    private NoListaDupla<T> proximo;

    public NoListaDupla(){}

    public NoListaDupla(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoListaDupla<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoListaDupla<T> anterior) {
        this.anterior = anterior;
    }

    public NoListaDupla<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "NoListaDupla{" +
                "anterior=" + (nonNull(anterior) ? anterior.getInfo() : "null")  +
                ", [info=" + info + "]" +
                ", proximo=" + (nonNull(proximo) ? proximo.getInfo() : "null")  +
                '}';
    }
}
