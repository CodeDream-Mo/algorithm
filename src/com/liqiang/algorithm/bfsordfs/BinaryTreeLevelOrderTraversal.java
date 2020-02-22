package com.liqiang.algorithm.bfsordfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * <p>Description: [二叉树的层次遍历]</p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> resultList = new ArrayList<>();

    /**
     * 使用BFS广度搜索（递归）
     * 时间复杂度:ON
     * 空间复杂度:ON
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        levelOrder(root, 0);
        return resultList;
    }

    public void levelOrder(TreeNode root, int level) {
        //注意:当集合与层级相等时证明该层级没有数据
        if (resultList.size() == level) {
            resultList.add(new ArrayList<>());
        }
        List<Integer> list = resultList.get(level);
        list.add(root.val);
        resultList.set(level, list);//重新设置该等级值
        if (root.left != null) {
            levelOrder(root.left, level + 1);
        }
        if (root.right != null) {
            levelOrder(root.right, level + 1);
        }
    }


    /**
     * 使用BFS广度搜索（非递归）
     * 实现思路:用两个queue 一个用来遍历输出， 一个用存储每层节点
     * 时间复杂度:ON
     * 空间复杂度:ON
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedTransferQueue<>();
        Queue<TreeNode> queue1 = new LinkedTransferQueue<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (queue.size() > 0 || queue1.size() > 0) {
            while (queue.size() > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue1.add(poll.left);
                }
                if (poll.right != null) {
                    queue1.add(poll.right);
                }
            }
            if (list.size() > 0) {
                resultList.add(list);
            }
            list = new ArrayList<>();
            while (queue1.size() > 0) {
                TreeNode poll = queue1.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (list.size() > 0) {
                resultList.add(list);
            }
            list = new ArrayList<>();
        }
        return resultList;
    }

    /**
     * 使用BFS广度搜索（非递归）
     * 实现思路:用1个queue
     * 时间复杂度:ON
     * 空间复杂度:ON
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedTransferQueue<>();
        queue.add(root);
        while (queue.size() > 0) {
            int length = queue.size();
            ArrayList list = new ArrayList();
            for (int i = 0; i < length; i++) {
                TreeNode remove = queue.remove();
                list.add(remove.val);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            resultList.add(list);
        }
        return resultList;
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
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        treeNode.left = treeNode1;
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode.right = treeNode2;
        List<List<Integer>> lists = levelOrder3(treeNode);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        b.hh();
    }

}
