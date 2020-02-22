package com.liqiang.algorithm;

/**
 * 平衡二叉树实现
 */
public class BinarySearchTree {
    int data;//数据
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void insert(BinarySearchTree root, int data) {
        //大于放在右子树
        if (root.data < data) {
            if (root.right == null) {
                root.right = new BinarySearchTree(data);
            } else {//右子树不等于空，就遍历到最后一个节点
                insert(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new BinarySearchTree(data);
            } else {
                insert(root.left, data);
            }
        }
    }

    //中序遍历
    public void in(BinarySearchTree root) {
        if (root != null) {
            in(root.left);
            System.out.println(root.data);
            in(root.right);
        }
    }

    public static void main(String[] args) {
        int data[] = {5, 9, 0, 1, 2, 3, 10};
        BinarySearchTree root = new BinarySearchTree(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insert(root, data[i]);
        }
        System.out.println("中序遍历为:");
        root.in(root);
    }
}
