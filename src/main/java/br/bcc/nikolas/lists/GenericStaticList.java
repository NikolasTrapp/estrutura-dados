package br.bcc.nikolas.lists;

public class GenericStaticList {

    private static final int PART_SIZE = 10;
    private int size = 0;
    private Object[] numbers;

    /**
     * Starts a new list with initial {@value PART_SIZE} size.
     */
    public GenericStaticList() {
        this.numbers = new Object[PART_SIZE];
    }

    private void resize() {
        Object[] tempNumbers = new Object[size + PART_SIZE];
        for (int i = 0; i < getSize(); i++) {
            tempNumbers[i] = numbers[i];
        }
        this.numbers = tempNumbers;
    }

    public void add(Object number) {
        if (this.numbers.length == size) {
            resize();
        }
        this.numbers[size] = number;
        this.size++;
    }

    public void prObjectNumbers() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
        for (Object number : numbers) {
            System.out.println(number);
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public int find(Object number) {
        for (int i = 0; i < getSize(); i++) {
            if (numbers[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Object number) {
        int index = find(number);

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
        this.size--;
        return true;
    }

    public void free() {
        this.numbers = new Object[PART_SIZE];
        this.size = 0;
    }

    public Object getNumber(int index) {
        if (index > getSize() || index < 0) {
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
