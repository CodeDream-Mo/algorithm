package com.liqiang.algorithm;

import java.util.Stack;

/**
 * <p>Description: [栈实现队列] https://leetcode-cn.com/problems/implement-queue-using-stacks/</p>
 * Created on 2019/7/18 20:32
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class MyQueue {
    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;
    private int front ;//队列首元素

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    /**
     * Push element x to the back of queue.
     * 时间复杂度O(N)
     */
    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            Integer pop = stack2.pop();
            front = pop;
            stack1.push(pop);
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Integer pop = stack1.pop();
        if (!stack1.isEmpty()) {
            front = stack1.peek();
        }
        return pop;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }

    class MyQueue1 {
        Stack<Integer> stack1 = null;
        Stack<Integer> stack2 = null;
        private int front;

        /**
         * Initialize your data structure here.
         */
        public MyQueue1() {
            stack1 = new Stack();
            stack2 = new Stack();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (stack1.isEmpty()) {
                front = x;
            }
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         * 时间复杂度O(N)
         */
        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!stack2.isEmpty()) {
                return stack2.peek();
            }
            return front;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack2.isEmpty() && stack1.isEmpty();
        }
    }
}