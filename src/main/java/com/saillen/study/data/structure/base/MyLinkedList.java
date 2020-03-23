package com.saillen.study.data.structure.base;

/**
 * @author : saillen
 * @date: 2020/3/21
 **/
public class MyLinkedList<T> implements MyList<T> {

    private transient int size;
    private transient MyLinkedListNode first;
    private transient MyLinkedListNode last;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T t) {
        if (t == null) {
            throw new IllegalArgumentException("item is null");
        }

        MyLinkedListNode tmp = first;

        while (tmp == null || tmp == last) {
            if (tmp.data.equals(t)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public T add(T newData) {
        if (first == null) {
            MyLinkedListNode<T> node = new MyLinkedListNode<>(null, newData, null);
            first = last = node;
        } else {
            MyLinkedListNode<T> node = new MyLinkedListNode<>(last, newData, null);
            last.next = node;
        }

        return newData;
    }

    @Override
    public T set(int idx, T newData) {
        return null;
    }

    @Override
    public T remove(int idx) {
        return null;
    }

    @Override
    public T get(int idx) {
        return null;
    }
}
