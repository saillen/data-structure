package com.saillen.study.data.structure.tree;

/**
 * @author : saillen
 * @date: 2020/3/21
 **/
public class BTreeTraverseRecursionImpl implements IBTreeTraverse {

    @Override
    public String traverse(BTreeNode root, int model) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        if (model == MODEL_FIRST) {
            rootFirst(root, sb);
        } else if (model == MODEL_MIDDLE) {
            rootMiddle(root, sb);
        } else if (model == MODEL_LAST) {
            rootLast(root, sb);
        } else {
            throw new IllegalArgumentException("invalid model value : " + model);
        }

        return sb.toString();
    }


    private static void rootFirst(BTreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.getData());
        rootFirst(node.getLeft(), sb);
        rootFirst(node.getRight(), sb);
    }

    private static void rootMiddle(BTreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        rootMiddle(node.getLeft(), sb);
        sb.append(node.getData());
        rootMiddle(node.getRight(), sb);
    }

    private static void rootLast(BTreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        rootLast(node.getLeft(), sb);
        rootLast(node.getRight(), sb);
        sb.append(node.getData());
    }


}
