package com.liqiang.algorithm;
/**
 * <p>Description: [给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。]</p>
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * Created on 2019/7/11 10:55
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class KthSmallestElementInBST {
    int kValue, count;
    boolean flag = false;

    /**
     * 使用中序遍历(左中右)
     * 时间复杂度(ON)
     * 空间复杂度（ON）
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        nodeBST(root , k);
        return kValue;
    }

    public void nodeBST(TreeNode root ,int k){
        if(root == null){
            return;
        }
        nodeBST(root.left, k);
        if(flag){
            return;
        }
        if(++count == k){
            kValue = root.val;
            flag = true;
        }
        nodeBST(root.right, k);
    }
}
