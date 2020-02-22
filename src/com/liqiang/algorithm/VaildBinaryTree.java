package com.liqiang.algorithm;

import java.util.Stack;

/**
 * <p>Description: [验证二叉树是否合法 左侧比父节点小，右侧比父节点大]</p>
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class VaildBinaryTree {
    /**
     * 广度遍历
     * 时间复杂度ON 每个节点访问一次
     * 空间复杂度ON 我们跟进了整个树
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return validTreeNode(root, null, null);
    }

    private boolean validTreeNode(TreeNode root, Integer upper, Integer lower) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (upper != null && val <= upper) {
            return false;
        }
        if (lower != null && val >= lower) {
            return false;
        }
        if (!validTreeNode(root.left, upper, val)) {
            return false;
        }
        if (!validTreeNode(root.right, val, lower)) {
            return false;
        }

        return true;
    }

    /**
     * 深度遍历，中序遍历(左侧节点-根节点-右侧节点，先遍历左侧节点      ，而后返回查看左侧节点是否有右侧节点，一层层出栈，一直到根节点然后遍历右侧链)
     * 时间复杂度 ON 最多遍历一次
     * 空间复杂度 ON
     */
    private boolean vaildDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int value = -Integer.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            if (treeNode.val <= value) {
                return false;
            }
            value = treeNode.val;
            root = treeNode.right;
        }
        return true;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        val = value;
    }
}