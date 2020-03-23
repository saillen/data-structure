package com.saillen.study.data.structure.base;

/**
 * @author : saillen
 * @date: 2020/3/21
 **/
public class MyLinkedListNode<T> {

    T data;

    MyLinkedListNode pre;
    MyLinkedListNode next;

    public MyLinkedListNode(MyLinkedListNode pre, T newData, MyLinkedListNode next) {
        this.pre = pre;
        this.data = newData;
        this.next = next;
    }
}
