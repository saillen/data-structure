package com.saillen.study.data.structure.tree;

import java.util.Stack;

/**
 * @author : saillen
 * @date: 2020/3/21
 **/
public class BTreeTraverseStackImpl implements IBTreeTraverse {
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

    private void rootLast(BTreeNode root, StringBuilder sb) {
        //
        Stack<BTreeNode> stack = new Stack<>();
        BTreeNode r = root;
        BTreeNode lastVisitNode = null;

        // 一直找到最左边的孩子
        while (r != null) {
            stack.push(r);
            r = r.getLeft();
        }
        r = stack.pop();

        // 循环的起步就是最左边的孩子
        while (r != null || !stack.isEmpty()) {
            // 这个节点可以被访问：没有右孩子，或者右孩子上次访问过了
            if (r.getRight() == null || r.getRight() == lastVisitNode) {
                sb.append(r);
                // 记录下，这样它的 father 就可以被访问了
                lastVisitNode = r;
                // 然后 pop 出它的 father 出来
                if (!stack.isEmpty()) {
                    r = stack.pop();
                } else {
                    // 注意 tree 的真正 root 最后被访问
                    r = null;
                }
            } else {
                // 如果没有访问它，那么就表示它有 right
                stack.push(r);
                // 转向 right 孩子，并找到 right 孩子的最左孩子
                r = r.getRight();
                while (r != null) {
                    stack.push(r);
                    r = r.getLeft();
                }
                r = stack.pop();
            }
        }
    }

    private void rootMiddle(BTreeNode root, StringBuilder sb) {
        // 非递归的中序遍历，使用栈的方式
        Stack<BTreeNode> stack = new Stack<>();
        BTreeNode r = root;

        while (r != null || !stack.isEmpty()) {
            // 一直找到最左边的节点
            while (r != null) {
                stack.push(r);
                r = r.getLeft();
            }
            r = stack.pop();

            // 访问它，然后转向它的右孩子
            sb.append(r);
            r = r.getRight();
        }

    }

    private void rootFirst(BTreeNode root, StringBuilder sb) {
        // 非递归的 先序遍历 其实就是一个手动去除尾递归的过程
        // 访问 root ，然后找到左孩子，然后访问 root，最后访问 right
        Stack<BTreeNode> stack = new Stack<>();
        BTreeNode r = root;
        while (r != null || !stack.isEmpty()) {
            // 访问 root ，然后到 left children 中去
            while (r != null) {
                sb.append(r);
                // 我们这里后面还需要 root 来访问它的 right
                stack.push(r);
                r = r.getLeft();
            }
            // 这里 r 肯定是 null，所以 pop 出来，转向它的 right 孩子
            r = stack.pop();
            r = r.getRight();
        }
    }

}
