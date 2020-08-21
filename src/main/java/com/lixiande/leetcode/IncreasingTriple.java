package com.lixiande.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class IncreasingTriple {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if(nums.length < 3) return false;
            Stack<Integer> stack = new Stack<>();
            for(int num : nums){
                if(stack.isEmpty()){
                    stack.push(num);
                }
                else {
                    if(num > stack.peek()){
                        stack.push(num);
                    }else {
                        while (!stack.isEmpty()&& num> stack.peek()){
                            stack.pop();
                        }
                        stack.push(num);
                    }
                }
                if(stack.size()==0 ) return true;
            }
            return false;
        }
    }
}
