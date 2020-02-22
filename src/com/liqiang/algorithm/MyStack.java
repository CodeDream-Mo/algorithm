package com.liqiang.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: [用队列实现栈]</p>
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 * Created on 2019/7/29 10:55
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */

//public class MyStack {
//    Queue<Integer> queue1 = new LinkedList<>();
//    Queue<Integer> queue2 = new LinkedList<>();
//
//    /**
//     * Initialize your data structure here.
//     */
//    public MyStack() {
//
//    }
//
//    /**
//     * Push element x onto stack.
//     * O(N)
//     */
//    public void push(int x) {
//        queue1.add(x);
//        while (!queue2.isEmpty()) {
//            queue1.add(queue2.remove());
//        }
//        Queue<Integer> tempQueue = queue1;
//        queue1 = queue2;
//        queue2 = tempQueue;
//    }
//
//    /**
//     * Removes the element on top of the stack and returns that element.
//     */
//    public int pop() {
//        return queue2.remove();
//    }
//
//    /**
//     * Get the top element.
//     */
//    public int top() {
//        return queue2.peek();
//    }
//
//    /**
//     * Returns whether the stack is empty.
//     */
//    public boolean empty() {
//        return queue2.isEmpty();
//    }
//}
public class MyStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    int front;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     * O(N)
     */
    public void push(int x) {
        queue1.add(x);
        front = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() > 1) {
            front = queue1.remove();
            queue2.add(front);
        }
        int tempTop = queue1.remove();
        Queue<Integer> tempQueue = queue2;
        queue2 = queue1;
        queue1 = tempQueue;
        return tempTop;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return front;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}