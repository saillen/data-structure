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
        Stack<BTreeNode> stack = new Stack<>();
        BTreeNode r = root;
        while (r != null || !stack.isEmpty()) {
            // 一直向左
            while (r != null) {
                stack.push(r);
                r = r.getRight();
            }

            //
            r = stack.pop();

        }
    }

    private void rootMiddle(BTreeNode root, StringBuilder sb) {
        Stack<BTreeNode> stack = new Stack<>();
        BTreeNode r = root;
        while (r != null || !stack.isEmpty()) {

            while (r != null) {
                // 一直向左找到叶子节点
                stack.push(r);
                r = r.getLeft();
            }

            // 栈顶是我们要输出的节点
            r = stack.pop();
            sb.append(r.getData());
            // 转向右节点
            r = r.getRight();
        }
    }

    private void rootFirst(BTreeNode root, StringBuilder sb) {
        // 非递归的 先序遍历 其实就是一个手动去除尾递归的过程
        // 思路：访问元素，然后把 right 入栈，left 入栈，left 出栈
        Stack<BTreeNode> stack = new Stack<>();
        BTreeNode r = root;
        while (r != null || !stack.isEmpty()) {
            // 把左子树遍历完
            while (r != null) {
                sb.append(r.getData());
                stack.push(r);
                r = r.getLeft();
            }
            // 转向右子树
            r = stack.pop();
            r = r.getRight();
        }
    }
}
