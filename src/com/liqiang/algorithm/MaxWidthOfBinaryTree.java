package com.liqiang.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: [二叉树最大宽度]</p>
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 * Created on 2019/7/11 16:32
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class MaxWidthOfBinaryTree {

    Map<Integer, int[]> map = new HashMap<>();
    int maxNum = 1;

    public int widthOfBinaryTree(TreeNode root) {
        getMaxWidth(root, 1, 1);
        return maxNum;
    }

    /**
     * DFS深度遍历
     * 时间复杂的ON
     * 空间复杂度ON
     * @param root        当前节点
     * @param storey      当前所属层
     * @param parentIndex 父节点下标(这里下标从1开始)
     * @return
     */
    private void getMaxWidth(TreeNode root, int storey, int parentIndex) {
        if (root.left == null && root.right == null) {
            return;
        }
        int[] ints = map.get(storey);
        if (ints == null) {
            ints = new int[2];
            ints[0] = root.left != null ? parentIndex * 2 - 1 : parentIndex * 2;
            map.put(storey, ints);
        }
        ints[1] = root.right != null ? parentIndex * 2 + 1 : parentIndex * 2;
        map.put(storey, ints);

        maxNum = maxNum > ints[1] - ints[0] ? maxNum : ints[1] - ints[0];
        if (root.left != null) {
            getMaxWidth(root.left, storey + 1, parentIndex * 2 - 1);
        }
        if (root.right != null) {
            getMaxWidth(root.right, storey + 1, parentIndex * 2);
        }
    }

    public static void main(String[] args) {
        MaxWidthOfBinaryTree maxWidthOfBinaryTree = new MaxWidthOfBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(3);
        TreeNode rightNode = new TreeNode(2);
        TreeNode leftNode1 = new TreeNode(5);
        TreeNode rightNode1 = new TreeNode(3);
        TreeNode rightNode2 = new TreeNode(9);
        rightNode.right = rightNode2;
        leftNode.left = leftNode1;
        leftNode.right = rightNode1;
        treeNode.left = leftNode;
        treeNode.right = rightNode;

        int width = maxWidthOfBinaryTree.widthOfBinaryTree(treeNode);
        System.out.println(width);
    }
}
