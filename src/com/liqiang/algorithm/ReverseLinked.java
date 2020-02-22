package com.liqiang.algorithm;


/**
 * <p>Description: [反转列表]https://leetcode-cn.com/problems/reverse-linked-list/</p>
 * Created on 2019/7/10 21:30
 *
 * @author <a href="mailto: 13930153501@163.com>李强</a>
 * @version 1.0
 */
public class ReverseLinked {
    /**
     * solution: 递归
     * 时间复杂度：O(n),假设n是列表的长度，时间复杂度是O(n)
     * 空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间，递归深度可能会达到n层。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * solution: 迭代
     *
     * 时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode currentNode = head;
        while(currentNode != null){
            ListNode tempNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = tempNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ReverseLinked reverseLinked = new ReverseLinked();
        ListNode listNode = reverseLinked.reverseList(listNode1);
        System.out.println(listNode.val+" "+listNode.next.val+"  ");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}