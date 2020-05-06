package com.saillen.study.algorithm;

/**
 * @author : saillen
 * @date: 2020/5/5
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreeFromArray(Integer[] nums) {
        int length = nums.length;
        if (length == 0) {
            return null;
        }

        TreeNode left, right;
        TreeNode[] treeArray = new TreeNode[length];
        for (int i = 0; i < length; i++) {
            // left node
            int leftIdx = 2 * i + 1;
            if (leftIdx < length) {
                left = treeArray[leftIdx];
                if (left == null) {
                    left = new TreeNode(nums[leftIdx]);
                    treeArray[leftIdx] = left;
                }
            } else {
                left = null;
            }

            // right node
            int rightIdx = 2 * i + 2;
            if (rightIdx < length) {
                right = treeArray[rightIdx];
                if (right == null) {
                    right = new TreeNode(nums[rightIdx]);
                    treeArray[rightIdx] = right;
                }
            } else {
                right = null;
            }

            TreeNode tmp = treeArray[i];
            if (tmp == null) {
                tmp = new TreeNode(nums[i], left, right);
                treeArray[i] = tmp;
            } else {
                tmp.left = left;
                tmp.right = right;
            }

        }

        return treeArray[0];
    }

    public static void printTreeNode() {

    }

    public static void main(String[] args) {
        Integer[] its = new Integer[]{10, 5, 15, 2, 3, 6, 20};
        TreeNode n = buildTreeFromArray(its);
    }

}
