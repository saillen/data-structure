package com.saillen.study.data.structure.tree;

/**
 * @author : saillen
 * @date: 2020/3/21
 **/
public class ArrayStoreTree<T> {

    private T[] treeNodes;

    public void addRoot(T data) {
        treeNodes[0] = data;
    }

}
