package br.bcc.nikolas.listaduplamenteencadeada;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ListaDupla <T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla() {
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoListaDupla<T> novoNode = new NoListaDupla<>(info);

        novoNode.setProximo(primeiro);

        if(nonNull(primeiro)) {
            primeiro.setAnterior(novoNode);
        }
        primeiro = novoNode;
    }

    public NoListaDupla<T> buscar(T info) {
        NoListaDupla<T> atual = getPrimeiro();

        if (isNull(atual)) {
            return null;
        }

        while (nonNull(atual)) {
            if (atual.getInfo().equals(info)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T info) {
        NoListaDupla<T> candidato = buscar(info);
        if (isNull(candidato)) {
            return;
        }

        NoListaDupla<T> anterior = candidato.getAnterior();
        NoListaDupla<T> proximo = candidato.getProximo();

        if (candidato.getInfo().equals(info)) {
            primeiro = proximo;

            if (nonNull(proximo)) {
                proximo.setAnterior(null);
            }
            return;
        }

        if (nonNull(anterior)) {
            anterior.setProximo(proximo);
        }

        if (nonNull(proximo)) {
            proximo.setAnterior(anterior);
        }
    }

    public void exibirOrdemInversa() {
        if (isNull(getPrimeiro())) {
            return;
        }
        System.out.println(imprimeNode(getPrimeiro()));
    }

    private String imprimeNode(NoListaDupla<T> info) {
        String str = "";
        str += info.getInfo().toString();
        if (nonNull(info.getProximo())) {
            str = imprimeNode(info.getProximo()) + "," + str;
        }
        return str;
    }

        public void liberar() {
            if (isNull(getPrimeiro())) {
                return;
            }
            removerNode(getPrimeiro());
            primeiro = null;
        }

        private void removerNode(NoListaDupla<T> info) {
            if (nonNull(info.getProximo())) {
                removerNode(info.getProximo());
            }
            info.setAnterior(null);
            info.setProximo(null);
        }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isNull(getPrimeiro())) {
            return "";
        }

        NoListaDupla<T> no = getPrimeiro();
        while (true) {
            sb.append(no.getInfo()).append(",");
            if (isNull(no.getProximo())) {
                break;
            }
            no = no.getProximo();
        }
        return sb.substring(0, sb.length()-1);
    }
}
