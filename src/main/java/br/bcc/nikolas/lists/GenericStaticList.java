package br.bcc.nikolas.lists;

import static java.util.Objects.isNull;

public class GenericStaticList <T> {

    private static final int PART_SIZE = 10;
    private int size = 0;
    private Object[] objects;

    /**
     * Starts a new list with initial {@value PART_SIZE} size.
     */
    public GenericStaticList() {
        this.objects = new Object[PART_SIZE];
    }

    private void resize() {
        Object[] tempObjects = new Object[size + PART_SIZE];
        for (int i = 0; i < getSize(); i++) {
            tempObjects[i] = objects[i];
        }
        this.objects = tempObjects;
    }

    public void add(T object) {
        if (this.objects.length == size) {
            resize();
        }
        this.objects[size] = object;
        this.size++;
    }

    public void printObjects() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
        for (Object object : objects) {
            System.out.println(object);
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public int find(T object) {
        if (isNull(object)) {
            throw new NullPointerException("Chapou linguiça");
        }
        for (int i = 0; i < getSize(); i++) {
            if (object.equals(objects[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(T object) {
        int index = find(object);

        if (index == -1) {
            return false;
        }

        for (int i = index; i < getSize(); i++) {
            if (i == size) {
                objects[i] = 0;
            } else {
                objects[i] = objects[i + 1];
            }
        }
        this.size--;
        return true;
    }

    public void free() {
        this.objects = new Object[PART_SIZE];
        this.size = 0;
    }

    public T getObject(int index) {
        if (index > getSize() || index < 0) {
            throw new IndexOutOfBoundsException("Chapou linguiça");
        }

        return (T) objects[index];
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
            sb.append(objects[i]);
            if (i < getSize() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
