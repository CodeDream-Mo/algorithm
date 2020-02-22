package com.liqiang.algorithm.bfsordfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: [二叉树的最大深度]</p>
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class MaximumDepthBinaryTree {
    int max = 0;

    /**
     * DFS 深度优先（递归）
     * 时间复杂度O(N)
     * 空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用N次（树的高度），因此保持调用栈的存储将是 O(N)。但在最好的情况下（树是完全平衡的），树的高度将是log(N)。因此，在这种情况下的空间复杂度将是 O(log(N))。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root, 1);
        return max;
    }

    /**
     * DFS(非递归)
     * 时间复杂度:ON
     * 空间复杂度:ON
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        int max = 0;//定义最大深度
        if (root == null) {
            return max;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        levelMap.put(root, 1);
        max = 1;
        while (root.left != null) {
            deque.push(root.left);
            int level = levelMap.get(root) + 1;
            levelMap.put(root.left, level);
            max = Math.max(level, max);
            root = root.left;
        }
        while (deque.size() > 0) {
            root = deque.removeFirst();
            while (root.right != null) {
                deque.push(root.right);
                int level = levelMap.get(root) + 1;
                levelMap.put(root.right, level);
                max = Math.max(level, max);
                root = root.right;
                while (root.left != null) {
                    deque.push(root.left);
                    levelMap.put(root.left, ++level);
                    root = root.left;
                }
                max = Math.max(level, max);
            }
        }
        return max;
    }

    public void maxDepth(TreeNode root, int level) {
        if (max < level) {
            max = level;
        }
        if (root.left != null) {
            maxDepth(root.left, level + 1);
        }
        if (root.right != null) {
            maxDepth(root.right, level + 1);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void hh() {
//        [4,-4,8,1,null,null,null,-4,-9,null,null,8,-9,7,-9,-6,6,null,null,null,null,null,null,-7,null,null,-1]

        MaximumDepthBinaryTree.TreeNode treeNode = new MaximumDepthBinaryTree.TreeNode(4);
        MaximumDepthBinaryTree.TreeNode treeNode1 = new MaximumDepthBinaryTree.TreeNode(-4);
        MaximumDepthBinaryTree.TreeNode treeNode2 = new MaximumDepthBinaryTree.TreeNode(8);
        MaximumDepthBinaryTree.TreeNode treeNode3 = new MaximumDepthBinaryTree.TreeNode(1);
        MaximumDepthBinaryTree.TreeNode treeNode4 = new MaximumDepthBinaryTree.TreeNode(-4);
        MaximumDepthBinaryTree.TreeNode treeNode5 = new MaximumDepthBinaryTree.TreeNode(-9);
        MaximumDepthBinaryTree.TreeNode treeNode6 = new MaximumDepthBinaryTree.TreeNode(8);
        MaximumDepthBinaryTree.TreeNode treeNode7 = new MaximumDepthBinaryTree.TreeNode(-9);
        MaximumDepthBinaryTree.TreeNode treeNode8 = new MaximumDepthBinaryTree.TreeNode(7);
        MaximumDepthBinaryTree.TreeNode treeNode9 = new MaximumDepthBinaryTree.TreeNode(-9);
        MaximumDepthBinaryTree.TreeNode treeNode10 = new MaximumDepthBinaryTree.TreeNode(-6);
        MaximumDepthBinaryTree.TreeNode treeNode11 = new MaximumDepthBinaryTree.TreeNode(6);
        MaximumDepthBinaryTree.TreeNode treeNode12 = new MaximumDepthBinaryTree.TreeNode(-7);
        MaximumDepthBinaryTree.TreeNode treeNode13 = new MaximumDepthBinaryTree.TreeNode(-1);
        treeNode12.right = treeNode13;
        treeNode11.left = treeNode12;
        treeNode7.left = treeNode10;
        treeNode7.right = treeNode11;
        treeNode6.left = treeNode8;
        treeNode6.right = treeNode9;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode1.left = treeNode3;
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        System.out.println(maxDepth2(treeNode));
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        deque.push(treeNode5);
//        deque.push(treeNode9);
//        System.out.println(deque.removeFirst().left.val);
//        System.out.println(deque.removeFirst().left.val);
    }

    public static void main(String[] args) {
        MaximumDepthBinaryTree b = new MaximumDepthBinaryTree();
        b.hh();
    }
}
