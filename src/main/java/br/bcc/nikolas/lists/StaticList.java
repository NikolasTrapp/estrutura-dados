package br.bcc.nikolas.lists;

import java.util.Arrays;

public class StaticList {

    private static final int PART_SIZE = 10;
    private int size = 0;
    public int[] numbers; //FIXME PUBLIC

    /**
     * Starts a new list with initial 10 spaces.
     */
    public StaticList() {
        this.numbers = new int[10];
    }

    /**
     * TODO remove/ Starts a new list with initial 10 spaces.
     */
    public StaticList(int ...objects) {
        this.numbers = objects;
        this.size = objects.length;
    }


    private void resize() {
        int[] tempNumbers = new int[size + PART_SIZE];
        int cont = 0;
        for (int x : this.numbers) {
            tempNumbers[cont] = x;
            cont++;
        }
        this.numbers = tempNumbers;
    }

    public void add(int number) {
        if (this.numbers.length == size) {
            resize();
        }
        this.numbers[size] = number;
        this.size++;
    }

    public void printNumbers() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
        for (int number : numbers) {
            System.out.println(number);
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public int find(int N) {
        for (int i = 0; i < getSize(); i++) {
            if (numbers[i] == N) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int n) {
        int index = -1;
        for (int i = 0; i < getSize(); i++) {
            if (numbers[i] == n) {
                index = i;
                this.size--;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        for (int i = index; i < getSize(); i++) {
            if (i == size) {
                numbers[i] = 0;
            } else {
                numbers[i] = numbers[i + 1];
            }
        }
        return true;
    }

    public void free() {
        this.numbers = new int[10];
        this.size = 0;
    }

    public int getNumber(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Chapou linguça");
        }

        return numbers[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            sb.append(numbers[i]);
            if (i < getSize() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
