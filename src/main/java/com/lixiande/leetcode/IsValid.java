package com.lixiande.leetcode;

import java.util.Stack;

public class IsValid {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] ch = s.toCharArray();
            for(char c : ch){
                if(c == '{'||c == '['||c == '('){
                    stack.push(c);
                }
                else {
                    if(stack.isEmpty()) return false;
                    if(c == ')'){
                        if( stack.peek() == (c-1)) {
                            stack.pop();
                        }
                        else {
                            return  false;
                        }
                    }else {
                        if( stack.peek() == (c-2)) {
                            stack.pop();
                        }
                        else {
                            return  false;
                        }
                    }

                }
            }
            if(!stack.isEmpty()) return false;
            return true;
        }
    }
}
