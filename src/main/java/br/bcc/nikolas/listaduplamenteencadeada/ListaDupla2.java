package br.bcc.nikolas.listaduplamenteencadeada;

public class ListaDupla2<T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla2() {
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoListaDupla<T> novoNode = new NoListaDupla<>();
        novoNode.setInfo(info);

        novoNode.setProximo(primeiro);

        if (primeiro != null) {
            primeiro.setAnterior(novoNode);
        }
        primeiro = novoNode;
    }

    public NoListaDupla<T> buscar(T info) {
        NoListaDupla<T> p = getPrimeiro();

        while (p != null) {
            if (primeiro.getInfo().equals(info)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T info) {
        NoListaDupla<T> p = buscar(info);
        if (p == null) {
            return;
        }

        NoListaDupla<T> anterior = p.getAnterior();
        NoListaDupla<T> proximo = p.getProximo();

        if (primeiro == p) {
            primeiro = proximo;
        }

        anterior.setProximo(proximo);
        if (proximo != null) {
            proximo.setAnterior(anterior);
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> p = getUltimo();

        if (p == null) {
            return;
        }

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getAnterior();
        }
    }

    private NoListaDupla<T> getUltimo() {
        if (primeiro == null) {
            return null;
        }

        NoListaDupla<T> p = primeiro;
        while (p.getProximo() != null) {
            p = p.getProximo();
        }
        return p;
    }

    public void liberar() {
        if (primeiro == null) {
            return;
        }
        NoListaDupla<T> p = primeiro;

        while (p != null) {
            p.setAnterior(null);
            NoListaDupla<T> b = p.getProximo();
            p.setProximo(null);
            p = b;
        }

        primeiro = null;



        primeiro = null;
    }

    private void removerNode(NoListaDupla<T> info) {
        if (info.getProximo() != null) {
            removerNode(info.getProximo());
        }
        info.setAnterior(null);
        info.setProximo(null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (primeiro == null) {
            return "";
        }

        NoListaDupla<T> no = getPrimeiro();
        while (true) {
            sb.append(no.getInfo()).append(",");
            if (no.getProximo() == null) {
                break;
            }
            no = no.getProximo();
        }
        return sb.substring(0, sb.length() - 1);
    }
}
