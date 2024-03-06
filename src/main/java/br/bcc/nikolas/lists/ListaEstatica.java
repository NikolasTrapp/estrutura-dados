package br.bcc.nikolas.lists;

public class ListaEstatica {

    private static final int PART_SIZE = 10;
    private int tamanho = 0;
    private int[] info;

    /**
     * Starts a new list with initial {@value PART_SIZE} tamanho.
     */
    public ListaEstatica() {
        this.info = new int[PART_SIZE];
    }

    private void redimensionar() {
        int[] tempNumbers = new int[tamanho + PART_SIZE];
        for (int i = 0; i < getTamanho(); i++) {
            tempNumbers[i] = info[i];
        }
        this.info = tempNumbers;
    }

    public void inserir(int number) {
        if (this.info.length == tamanho) {
            redimensionar();
        }
        this.info[tamanho] = number;
        this.tamanho++;
    }

    public void exibir() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
        for (int number : info) {
            System.out.println(number);
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public int buscar(int number) {
        for (int i = 0; i < getTamanho(); i++) {
            if (info[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public boolean retirar(int number) {
        int index = buscar(number);

        if (index == -1) {
            return false;
        }

        for (int i = index; i < getTamanho(); i++) {
            if (i == tamanho) {
                info[i] = 0;
            } else {
                info[i] = info[i + 1];
            }
        }
        this.tamanho--;
        return true;
    }

    public void liberar() {
        this.info = new int[PART_SIZE];
        this.tamanho = 0;
    }

    public int obterElemento(int index) {
        if (index > getTamanho() || index < 0) {
            throw new IndexOutOfBoundsException("Chapou linguiça");
        }

        return info[index];
    }

    public boolean estaVazia() {
        return getTamanho() == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void inverter() {
        if (getTamanho() <= 0) {
            throw new IllegalStateException("Ta chapando?");
        }

        int s = (getTamanho() - 1) / 2;

        for (int i = 0; i <= s; i++) {
            int opposite = getTamanho() - 1 - i;
            int temp = this.info[i];
            this.info[i] = this.info[opposite];
            this.info[opposite] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getTamanho(); i++) {
            sb.append(info[i]);
            if (i < getTamanho() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
