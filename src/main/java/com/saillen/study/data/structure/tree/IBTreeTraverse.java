package com.saillen.study.data.structure.tree;

/**
 * @author : saillen
 * @date: 2020/3/21
 **/
public interface IBTreeTraverse {

    int MODEL_FIRST = 1;
    int MODEL_MIDDLE = 2;
    int MODEL_LAST = 3;

    String traverse(BTreeNode root, int model);

}
