package com.liqiang.algorithm;

/**
 * <p>Description: [链表中元素两两交换]</p>
 * [链表中K个元素交换]https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * Created on 2019/7/11 16:32
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class LinkedListSwap {

    /**
     * 递归解法
     * 时间复杂度O(n)
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        //返回值
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        //交换
        node.next = head;
        return node;//返回值为交换子串

    }

    /**
     * 迭代解法
     * 1 后面为3,2后面为1，开始为2
     * 时间复杂度O(N)
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = new ListNode(0);
        preNode.next = head;
        ListNode tempNode = preNode;//迭代元素
        while (tempNode.next != null && tempNode.next.next != null) {
            //交换元素
            ListNode start = tempNode.next;//交换元素
            ListNode end = tempNode.next.next;//结尾元素
            start.next = end.next;
            end.next = start;
            tempNode.next = end;
            //重置元素遍历位置
            tempNode = end.next;
        }
        return preNode.next;

    }

    /**
     * 翻转K个长度元素，不够K个长度的元素不翻转
     * 时间复杂度:最小O(K*N)  最大O(n2)N平方
     * 空间复杂度:O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <=1 || head == null){
            return head;
        }
        ListNode filter = head;
        for(int i=1;i<k;i++){
            if(filter.next == null){
                return head;
            }
            filter = filter.next;
        }
        ListNode newNode = null;
        ListNode startNode = null;
        ListNode endNode = null;
        ListNode childNode = head;
        for(int i=1;i<k;i++){
            ListNode tempNode = childNode.next;
            if(i == 1){
                endNode = head;
                childNode.next = childNode.next.next;
                tempNode.next = childNode;
            }else{
                childNode.next = childNode.next.next;
                tempNode.next = newNode;
            }
            newNode = tempNode;
            childNode = endNode;
        }

        if(endNode.next != null){
            ListNode reverseNode = reverseKGroup(endNode.next,k);
            endNode.next = reverseNode;
        }
        return newNode;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode1;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        LinkedListSwap linkedListSwap = new LinkedListSwap();
        ListNode listNode = linkedListSwap.swapPairs2(listNode1);
        System.out.println(listNode.val + " " + listNode.next.val + "  " + "  " + listNode.next.next.val + "     " + listNode.next.next.next.val);
    }

}
