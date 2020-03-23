package com.saillen.study.data.structure.tree;

/**
 * @author : saillen
 * @date: 2020/3/21
 **/
public class BTreeNode<T> {

    private T data;

    private BTreeNode<T> left;

    private BTreeNode<T> right;

    private boolean flag = true;

    public BTreeNode(BTreeNode left, T data, BTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String toString() {
        return data == null ? "null" : data.toString();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BTreeNode<T> left) {
        this.left = left;
    }

    public BTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BTreeNode<T> right) {
        this.right = right;
    }
}
