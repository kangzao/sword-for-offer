package com.jep.github.leetcode;

import java.util.Stack;

/**
 * author jiangenping
 * 2020/3/2 下午10:38
 */

public class _155_MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public _155_MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty() || minStack.peek() >= number) {
            minStack.push(number);
        }
    }

    public int pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int getMin() {
        return minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public static void main(String[] args){
        _155_MinStack minStack = new _155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
