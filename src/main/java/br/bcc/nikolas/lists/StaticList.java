package br.bcc.nikolas.lists;

public class StaticList {

    private static final int PART_SIZE = 10;
    private int size = 0;
    private int[] numbers;

    /**
     * Starts a new list with initial {@value PART_SIZE} size.
     */
    public StaticList() {
        this.numbers = new int[PART_SIZE];
    }

    private void resize() {
        int[] tempNumbers = new int[size + PART_SIZE];
        for (int i = 0; i < getSize(); i++) {
            tempNumbers[i] = numbers[i];
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

    public int find(int number) {
        for (int i = 0; i < getSize(); i++) {
            if (numbers[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int number) {
        int index = -1;
        for (int i = 0; i < getSize(); i++) {
            if (numbers[i] == number) {
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
        this.numbers = new int[PART_SIZE];
        this.size = 0;
    }

    public int getNumber(int index) {
        if (index > getSize()) {
            throw new IndexOutOfBoundsException("Chapou linguiça");
        }

        return numbers[index];
    }

    public boolean isEmpty() {
        return getSize() == 0;
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
