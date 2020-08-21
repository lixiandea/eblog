package com.lixiande.leetcode;

import org.apache.ibatis.javassist.CodeConverter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.peek()<x){
            int temp = minStack.peek();
            minStack.push(temp);
        }else {
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.size()==1) {
            stack.clear();
            minStack.clear();
            minStack.push(Integer.MAX_VALUE);
        }
        else {
            stack.pop();
            minStack.pop();
        }


    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();

    }


}