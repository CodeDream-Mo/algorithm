package com.liqiang.algorithm;

import java.util.*;

/**
 * <p>Description: [最近公共祖先]</p>
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Created on 2019/7/11 10:55
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class LowestCommonAncestor {
    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归-回溯根节点
        recursion(root, p, q);
        return result;
    }


    /**
     * 方法一后序遍历判断是否存在,用boolean接收是为了回溯
     * 时间复杂度(ON)
     * 空间复杂度（ON）
     * @param root
     * @param p
     * @param q
     * @return
     */
    public boolean recursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int leftExist = recursion(root.left, p, q) ? 1 : 0;
        int rightExist = recursion(root.right, p, q) ? 1 : 0;
        int rootExist = 0;
        if (root == p || root == q) {
            rootExist = 1;
        }
        if ((rootExist + leftExist + rightExist) >= 2) {
            result = root;
        }
        return (rootExist + leftExist + rightExist) > 0;
    }
    /**
     * 方法二 先获取节点所有祖先,再根据一个节点向上查找
     * 时间复杂度(ON)
     * 空间复杂度（ON）
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //使用deque遍历根节点，使用Map存储p,q所有父节点
        Deque<TreeNode> deque = new ArrayDeque<>();
        Map<TreeNode,TreeNode> map = new HashMap<>();

        deque.push(root);
        map.put(root, null);

        while(!map.containsKey(p) || !map.containsKey(q)){
            TreeNode currentNode =  deque.pop();

            if(currentNode.left != null){
                map.put(currentNode.left,currentNode);
                deque.push(currentNode.left);
            }
            if(currentNode.right != null){
                map.put(currentNode.right,currentNode);
                deque.push(currentNode.right);
            }
        }

        //获取P的父链
        Set<TreeNode> set = new HashSet<>();
        while(p != null){
            set.add(p);
            p = map.get(p);
        }

        //Q向上查找公共父节点
        while(!set.contains(q)){
            q = map.get(q);
        }
        return q;
    }
}
