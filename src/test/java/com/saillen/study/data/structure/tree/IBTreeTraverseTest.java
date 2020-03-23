package com.saillen.study.data.structure.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * @author : saillen
 * @date: 2020/3/21
 **/
public class IBTreeTraverseTest {


    BTreeNode root;

    /**
     * <pre>
     *           A
     *        /     \
     *      B        C
     *     / \     /  \
     *   D    E   F    G
     * </pre>
     */
    @Before
    public void init() {
        BTreeNode d = new BTreeNode(null, "D", null);
        BTreeNode e = new BTreeNode(null, "E", null);
        BTreeNode f = new BTreeNode(null, "F", null);
        BTreeNode g = new BTreeNode(null, "G", null);
        BTreeNode b = new BTreeNode(d, "B", e);
        BTreeNode c = new BTreeNode(f, "C", g);
        root = new BTreeNode(b, "A", c);
    }

    @Test
    public void traverse() {
        IBTreeTraverse traverse = new BTreeTraverseRecursionImpl();
        System.out.println(traverse.traverse(root, 1));
        System.out.println(traverse.traverse(root, 2));
        System.out.println(traverse.traverse(root, 3));
    }

    @Test
    public void traverse2() {
        IBTreeTraverse traverse = new BTreeTraverseStackImpl();
        System.out.println(traverse.traverse(root, 1));
        System.out.println(traverse.traverse(root, 2));
        System.out.println(traverse.traverse(root, 3));
    }
}
