package pl.javastart.task;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CustomList<E> {
    private Object[] elementData;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public CustomList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public void add(E element) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            elementData = Arrays.copyOf(elementData, DEFAULT_CAPACITY);
        }
        increaseArrayIfNecessary();

        elementData[size] = element;
        size++;
    }

    public boolean add(int index, E element) {
        increaseArrayIfNecessary();
        elementData = Arrays.copyOf(elementData, size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
        return true;
    }

    public E get(int index) {
        verifyIndex(index);
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public boolean remove(int index) {
        verifyIndex(index);

        elementData = IntStream.range(0, size)
                .filter(element -> element != index)
                .mapToObj(i -> elementData[i])
                .toArray();
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder();
        for (int i = 0; i < size; i++) {
            elements.append(elementData[i]);
            if (i != size - 1) {
                elements.append(", ");
            }
        }
        return "[" + elements + "]";
    }

    private void increaseArrayIfNecessary() {
        if (elementData.length == size) {
            elementData = Arrays.copyOf(elementData, size * 2);
        }
    }

    private void verifyIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }
}
