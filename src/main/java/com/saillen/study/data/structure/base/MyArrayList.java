package com.saillen.study.data.structure.base;

/**
 * @author : saillen
 * @date: 2020/3/21
 **/
public class MyArrayList<T> implements MyList<T> {

    private Object[] elements;
    private int curSize;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int size) {
        elements = new Object[size];
    }

    public int size() {
        return curSize;
    }

    public boolean contains(T t) {
        if (t == null) {
            return false;
        }
        for (int i = 0; i < curSize; i++) {
            if (t.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public T add(T newData) {
        if (curSize >= elements.length) {
            resize();
        }

        elements[curSize] = newData;
        curSize++;
        return newData;
    }

    private void resize() {
        int newSize = curSize * 2;
        Object[] newElements = new Object[newSize];
        System.arraycopy(elements, 0, newElements, 0, curSize);
    }

    public T set(int idx, T newData) {
        if (idx >= curSize) {
            throw new IllegalArgumentException("idx is bigger than current size");
        }
        Object obj = elements[idx];
        elements[idx] = newData;
        return (T) obj;
    }

    public T remove(int idx) {
        if (idx >= curSize) {
            throw new IllegalArgumentException("idx is bigger than current size");
        }
        Object obj = elements[idx];
        for (; idx < curSize - 1; idx++) {
            elements[idx] = elements[idx + 1];
        }
        curSize--;
        return (T) obj;
    }

    public T get(int idx) {
        if (idx < curSize) {
            return (T) elements[idx];
        }
        return null;
    }
}
